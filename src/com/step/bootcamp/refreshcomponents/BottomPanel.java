package com.step.bootcamp.refreshcomponents;

import java.util.ArrayList;

public class BottomPanel implements Component {
    private ArrayList<Component> nodes = new ArrayList<>();
    @Override
    public String refresh() {
        String refreshToken = "";
        for (Component node : nodes) {
            refreshToken += node.refresh();
        }
        return "refreshing bottom panel " + refreshToken;
    }

    @Override
    public void addNode(Component node) {
        nodes.add(node);
    }
}
