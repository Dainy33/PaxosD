package com.dainy33.example;

import com.dainy33.node.GroupSMInfo;
import com.dainy33.node.Node;
import com.dainy33.node.Options;
import com.github.luohaha.connection.Conn;
import com.github.luohaha.param.ServerParam;
import com.github.luohaha.server.LightCommServer;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class PaxosKVServer2 {
    private Node node = new Node();
    private String confFile;
    private ServerConf serverConf;

    private Set<Conn> conns = new HashSet<>();
    private LightCommServer commServer;

    public PaxosKVServer2(String confFile) {
        this.confFile = confFile;
    }

    /**
     *
     */
    public void init() {
        Gson gson = new Gson();
        serverConf = gson.fromJson(FileUtils.readFromFile(confFile), ServerConf.class);

        ServerParam param = new ServerParam(serverConf.getRequestIP(), serverConf.getRequestPort());
        param.setBacklog(128);
        param.setOnAccept(conn -> conns.add(conn));
        param.setOnRead((conn, msg) -> {
            node.commit(0, new String(msg));
            System.out.println("Recv: " + new String(msg));
        });
        param.setOnClose(conn -> conns.remove(conn));
        param.setOnReadError((conn, err) -> System.out.println(err.getMessage()));
        param.setOnWriteError((conn, err) -> System.out.println(err.getMessage()));
        param.setOnAcceptError(err -> System.out.println(err.getMessage()));

        commServer = new LightCommServer(param, 4);
    }

    /**
     * start kv server
     */
    public void startServer() {
        // start comm server to recv client request
        try {
            commServer.start();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Init options
        Options options = new Options(1);
        options.setPaxosConf(serverConf.getPaxosConf());
        options.setNodes(serverConf.getNodes());
        options.setMyNodeID(serverConf.getMyNodeID());

        // add sm
        GroupSMInfo groupSMInfo = new GroupSMInfo(0);
        groupSMInfo.addSM(new KVStateMachine());
        options.addGroupSMInfo(groupSMInfo);

        // Run Node
        node.runNode(options);
    }


    public static void main(String[] args) {
        String confFile = Paths.get(System.getProperty("user.dir"),"/example/conf/server2.json").toString();
        PaxosKVServer2 server = new PaxosKVServer2(confFile);
        server.init();
        server.startServer();
    }
}
