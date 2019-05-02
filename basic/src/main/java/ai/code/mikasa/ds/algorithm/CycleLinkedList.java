package ai.code.mikasa.ds.algorithm;

/**
 * 判断一个链表是否有环
 */
public class CycleLinkedList {

    public static void main(String[] args){
        CycleLinkedList instance = new CycleLinkedList();

        LinkNode head = instance.buildCycleLinkedList();

        System.out.println("该链表有环：" + instance.isCycle(head));
    }

    public LinkNode buildCycleLinkedList(){

        LinkNode head = new LinkNode(1, null);
        LinkNode node2 = new LinkNode(2, null);
        LinkNode node3 = new LinkNode(3, null);
        LinkNode node4 = new LinkNode(4, null);
        LinkNode node5 = new LinkNode(5, null);
        LinkNode node6 = new LinkNode(6, null);

        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        node4.setNext(node5);
        node5.setNext(node6);
        node6.setNext(node3);

        return head;
    }

    public boolean isCycle(LinkNode head){
        if(head == null){
            return false;
        }

        LinkNode p = head, q = head;
        while (q != null && q.next != null){
            p = p.next;
            q = q.next.next;
            if(p == q){
                return true;
            }
        }

        return false;
    }

    /**
     * 链表节点
     */
    class LinkNode{
        private int data;
        private LinkNode next;

        public LinkNode(int data, LinkNode next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public LinkNode getNext() {
            return next;
        }

        public void setNext(LinkNode next) {
            this.next = next;
        }
    }
}
