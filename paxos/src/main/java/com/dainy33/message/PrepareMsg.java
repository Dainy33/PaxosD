package com.dainy33.message;

import com.google.gson.annotations.SerializedName;

/**
 * Created by dainy33 on 2019-04-16.
 */
public class PrepareMsg extends BasePaxosMsg {
    // 提议的编号
    @SerializedName("proposal_id")
    private int proposalID;

    public int getProposalID() {
        return proposalID;
    }

    public void setProposalID(int proposalID) {
        this.proposalID = proposalID;
    }

    @Override
    public String toString() {
        return "PrepareMsg{" +
                "proposalID=" + proposalID +
                '}';
    }
}
