
/**
 * Created by PauloPalma on 26/06/2016.
 */
public class ArvorePesquisaBinaria {

    private static Node root;

    private ArvorePesquisaBinaria() {
        root = null;
    }

    public boolean find(int id) {

        Node current = root;

        while (current != null) {
            if (current.getData() == id) {
                return true;
            } else if (current.getData() > id) {
                current = current.getLeft();
            } else {
                current = current.right;
            }
        }
        return false;
    }

    private void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (id < current.getData()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    private boolean delete(int id) {

        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while (current.getData() != id) {
            parent = current;
            if (current.getData() > id) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }

        //Ao chegar aqui significa que o nó a eliminar existe
        // 1 - Se o nó não tem nós associados
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.setLeft(null);
            } else {
                parent.setLeft(null);
            }
            //2 - Se o nó tem apenas um nó associado
        } else if (current.getRight() == null){
            if (current ==root){
                root = current.getLeft();
            }else if (isLeftChild){
                parent.setLeft(current.getLeft());
            }else {
                parent.setRight(current.getLeft());
            }

        }else if(current.getLeft() == null){
            if(current == root){
                root = current.getRight();
            }else if(isLeftChild){
                parent.setLeft(current.getRight());
            }else {
                parent.setRight(current.getRight());
            }

        }else if(current.getLeft()!=null && current.getRight() != null){

            Node successor = getSuccessor(current);
            if (current == root){
                root =successor ;
            }else if(isLeftChild){
                parent.setLeft(successor);
            }else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());

        }

        return true;

    }

    private Node getSuccessor(Node deleteNode) {

        Node successsor =null;
        Node successsorParent =null;
        Node current = deleteNode.right;
        while(current!=null){
            successsorParent = successsor;
            successsor = current;
            current = current.left;
        }
        //check if successor has the right child, it cannot have left child for sure
        // if it does have the right child, add it to the left of successorParent.
//		successsorParent
        if(successsor!=deleteNode.right){
            successsorParent.left = successsor.right;
            successsor.right = deleteNode.right;
        }
        return successsor;


    }

    private void display(Node root) {
        if (root != null) {
            display(root.left);
            System.out.print(" " + root.data);
            display(root.right);
        }
    }


    public static void main(String[] args) {
        ArvorePesquisaBinaria b = new ArvorePesquisaBinaria();

        b.insert(3);
        b.insert(10);
        b.insert(8);
        b.insert(1);
        System.out.println("Original Tree : ");
        b.display(root);

        System.out.println();
        System.out.println("Check whether Node with value 3 exists : " + b.find(3));

        System.out.println("Delete Node with no children (2) : " + b.delete(3));
        b.display(root);

        System.out.println();
        System.out.println("Check whether Node with value 3 exists : " + b.find(3));

        System.out.println("New Tree : ");
        b.display(root);

    }


}
