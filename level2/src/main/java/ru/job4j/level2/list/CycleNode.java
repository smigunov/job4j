package ru.job4j.level2.list;

public class CycleNode<T> {
    T value;
    CycleNode<T> next;
    private boolean alreadyChecked = false;

    private void FlushLabels() {
        CycleNode<T> node = this;
        while((node.next != null) &&  (node.alreadyChecked))  {
            node.alreadyChecked = false;
            node = node.next;
        }
    }


    public boolean hasCycle() {
        boolean result = false;
        this.FlushLabels();

        CycleNode<T> curNode = this;
        while(curNode.next != null) {
            curNode.alreadyChecked = true;
            if (curNode.next.alreadyChecked) {
                result = true;
                break;
            }
            curNode.alreadyChecked = true;
            curNode = curNode.next;
        }
        return result;
    }
}
