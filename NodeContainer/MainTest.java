package NodeContainer;

import NodeContainer.NodeContainer;

public class MainTest {
    public static void main(String[] args) {
    NodeContainer container = new NodeContainer();
    Object o = new Object();
    Object o2 = new Object();
    Object o3 = new Object();
    Object o4 = new Object();


    container.add(o);
    container.add(o2);
    container.add(o3);
    container.add(o4);

        System.out.println(container.size());
    }

}
