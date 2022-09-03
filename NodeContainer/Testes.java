package NodeContainer;

import NodeContainer.NodeContainer;

public class Testes {
    public static void main(String[] args) {
        addObjectandExpect_getSizeEqualOne();
        addTwoObjectandExpect_getSizeEqualOne();
        addObjectToContainerAndExpectToReturnSameObject();
        addNullObjectToContainerShouldReturnFalse();
        getNegativeIndexShouldThrowAnError();
        getNullObjectFromHeadShouldThrowOutOfBounds();
        getIndexBiggerThanLengthShouldThrowAnError();
        deleteByIndexShouldHaveSizeDecreased();
        deleteByMiddleIndexShouldHaveSizeDecreased();
        getByObjectShouldReturnIndex();


    }


    private static void addObjectandExpect_getSizeEqualOne() {
        NodeContainer contentor = new NodeContainer();
        Object o = new Object();
        contentor.add(o);

        if (contentor.size() != 1) {
            throw new RuntimeException("Node container should be equal to one " + contentor.size());
        }
    }

    private static void addTwoObjectandExpect_getSizeEqualOne() {
        NodeContainer contentor = new NodeContainer();
        Object o = new Object();
        Object o2 = new Object();
        contentor.add(o);
        contentor.add(o2);

        if (contentor.size() != 2) {
            throw new RuntimeException("Node container should be equal to two " + contentor.size());
        }
    }


    private static void addObjectToContainerAndExpectToReturnSameObject() {
    NodeContainer contentor = new NodeContainer();
    Object o = new Object();
    Object o2 = new Object();
    contentor.add(o);
    contentor.add(o2);

    if (contentor.get(0) != o){
        throw new RuntimeException("The node container need to return the same object");
    }
    }

    private static void addNullObjectToContainerShouldReturnFalse() {
        //GIVEN
        NodeContainer nodeContainer = new NodeContainer();
        //WHEN
        nodeContainer.add(null);

        if(nodeContainer.add(null)){
            throw new RuntimeException("Node container should not add null objects ");
        }

        if(nodeContainer.size() > 0){
            throw new RuntimeException("Node container should not add null objects ");
        }

    }
    private static void getNegativeIndexShouldThrowAnError() {
        //GIVEN
        NodeContainer nodeContainer = new NodeContainer();


        //WHEN
        try{
            nodeContainer.get(-1);
        } catch (ArrayIndexOutOfBoundsException e){
            return;
        }


        //THEN
        throw new RuntimeException("Node container get index cant be less than 0");

    }

    private static void getNullObjectFromHeadShouldThrowOutOfBounds() {
        //GIVEN
        NodeContainer nodeContainer = new NodeContainer();
        //WHEN
        try{
            nodeContainer.get(0);
        } catch (ArrayIndexOutOfBoundsException e){
            return;
        }
        //THEN
        throw new RuntimeException("Node container get null head does not throw exception ");

    }

    private static void getIndexBiggerThanLengthShouldThrowAnError() {
        NodeContainer nodeContainer = new NodeContainer();
        //WHEN
        try{
            nodeContainer.get(1);
        } catch (ArrayIndexOutOfBoundsException e){
            return;
        }
        //THEN
        throw new RuntimeException("Node container get index bigger ");
    }

    private static void deleteByIndexShouldHaveSizeDecreased() {
        NodeContainer nodeContainer = new NodeContainer();
        Object o = new Object();
        Object o2 = new Object();

        //WHEN
        nodeContainer.add(o);
        nodeContainer.add(o2);
        nodeContainer.remove(0);

        //THEN
        if(nodeContainer.size()!=1){
            throw new RuntimeException("Node container remove index should decrease size() ");
        }
    }

    private static void deleteByMiddleIndexShouldHaveSizeDecreased() {
        NodeContainer nodeContainer = new NodeContainer();
        Object o = new Object();

        //WHEN
        nodeContainer.add(o);
        nodeContainer.add(o);
        nodeContainer.remove(1);

        //THEN
        if(nodeContainer.size()!=1){
            throw new RuntimeException("Node container remove index should decrease size() ");
        }

    }
    private static void getByObjectShouldReturnIndex() {
        NodeContainer nodeContainer = new NodeContainer();
        Object o = new Object();

        //WHEN
        nodeContainer.add(o);
        //nodeContainer.indexOf(o);

        //THEN
        int index = nodeContainer.indexOf(o);
        if(index !=0){
            throw new RuntimeException("Node container get by Object not returning right index " + index);
        }
        Object o2 = new Object();

        nodeContainer.add(o2);

        if(nodeContainer.indexOf(o2)!=1){
            throw new RuntimeException("Node container get by Object not returning right index");
        }

        Object o3 = new Object();
        nodeContainer.add(o3);

        if(nodeContainer.indexOf(o3)!=2){
            throw new RuntimeException("Node container get by Object not returning right index");
        }
    }


}