package com.step.bootcamp.refreshcomponents;

import java.util.ArrayList;

public class SidePanel implements Component{
    private ArrayList<Component> nodes = new ArrayList<>();
    @Override
    public String refresh() {
        String refreshToken = "";
        for (Component node : nodes) {
            refreshToken += node.refresh();
        }
        System.out.println("refreshing side panel");
        return "refreshing side panel " + refreshToken;
    }

    @Override
    public void addNode(Component node) {
        nodes.add(node);
    }
}
