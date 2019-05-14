package com.dainy33.node;

import com.dainy33.comm.MsgTransport;
import com.dainy33.core.Committer;
import com.dainy33.core.InstanceManager;

/**
 * Created by dainy33 on 2019-04-14.
 */
public class Group {
    private int groupId;

    private com.dainy33.core.InstanceManager InstanceManager;
    private Committer committer;

    public Group(int groupId, MsgTransport msgTransport, NodeInfo curNode, int allNodeCount, GroupSMInfo groupSMInfo) {
        this.committer = new Committer();
        this.groupId = groupId;
        this.InstanceManager = new InstanceManager(msgTransport, curNode, committer, groupSMInfo, allNodeCount, groupId);
        InstanceManager.startInstance();
    }

    public int getGroupId() {
        return groupId;
    }

    public InstanceManager getInstanceManager() {
        return InstanceManager;
    }

    public Committer getCommitter() {
        return committer;
    }
}
