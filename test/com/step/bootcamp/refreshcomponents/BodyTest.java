package com.step.bootcamp.refreshcomponents;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BodyTest {
    @Test
    void shouldRefreshBodyComponentOnly() {
        Body body = new Body();
        String actual = body.refresh();
        String expected = "refreshing body ";

        assertEquals(expected,actual);
    }

    @Test
    void shouldRefreshBodyWithChildComponent() {
        Body body = new Body();
        body.addNode(new SidePanel());
        String actual = body.refresh();
        String expected = "refreshing body refreshing side panel ";

        assertEquals(expected,actual);
    }

    @Test
    void shouldRefreshBodyWithChildrenComponent() {
        Body body = new Body();
        body.addNode(new SidePanel());
        body.addNode(new BottomPanel());
        Content content = new Content();
        content.addNode(new Image());
        content.addNode(new Text());
        body.addNode(content);

        String actual = body.refresh();
        String expected = "refreshing body refreshing side panel refreshing bottom panel refreshing content refreshing image refreshing text ";

        assertEquals(expected,actual);
    }
}