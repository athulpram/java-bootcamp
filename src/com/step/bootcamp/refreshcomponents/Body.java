package com.step.bootcamp.refreshcomponents;

import java.util.ArrayList;
import java.util.List;

public class Body implements Component {
    private List<Component> nodes = new ArrayList<>();

    @Override
    public String refresh() {
        String refreshToken = "";
        for (Component node : nodes) {
            refreshToken += node.refresh();
        }

        System.out.println("refreshing body");
        return "refreshing body " + refreshToken;
    }

    @Override
    public void addNode(Component node) {
        nodes.add(node);
    }

}
