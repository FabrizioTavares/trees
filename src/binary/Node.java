
package binary;

public class Node {
    
    private String name;
    private int value;
    //private node parent;
    private Node left;
    private Node right;
    
    public Node(){
        this.name = "null";
        this.value = 0;
        this.left = null;
        this.right = null;
    }
    
    public Node(String name){
        this.name = name;
        this.value = 0;
        this.left = null;
        this.right = null;
    }
    
    public Node(int value){
        this.name = "null";
        this.value = value;
        this.left = null;
        this.right = null;
    }
    
    public Node(String name, int value){
        this.name = name;
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
    
    public int doHeight() // calcular altura
    {
        if((left == null) && (right == null)) // não há filhos = 0.
            return 0;

        int auxLeft = 0, auxRight = 0; // contadores
        
        if(left != null)
            auxLeft = left.doHeight(); 

        if(right != null)
            auxRight = right.doHeight();
        
        return 1 + Math.max(auxLeft, auxRight);
        // máximo da contagem tanto da esquerda quanto da direita, achando assim o caminho mais distante.
        
    }
    
    public boolean isEndpoint() { // Retorna se é nó folha ou não.
        return (this.getLeft() == null && this.getRight() == null);
    }
    
    public String StringEndpoint() { // Retorna se é nó folha ou não.
       if(this.getLeft() == null && this.getRight() == null){
           return "Yes";
       }
       else{
           return "No";
       }
    }
    
    public int grau() { // Retorna grau
        
        int count = 0;
        
        if (this.getLeft()!= null) {
            count++;
        }
        if (this.getRight() != null){
            count++;
        }
        
        return count;
    }
    
    public int doLevel(Node current) { // buscar nível
        
        int count = 0;
        
        if (this.value == current.value) { // este nó foi achado. retornar valor.
            return count++;
        }
        
        if (this.value < current.getValue()) { // navegar até à esquerda, em busca do nó
            count = 1 + doLevel(current.getLeft());
        }

        else if (this.value > current.getValue()) { // navegar até à direita, em busca do nó
            count = 1 + doLevel(current.getRight());
        }

        return count;
        
    }
    /*
    public int getDepthBT(){ // profundidade de um nó
        Iterador it = new Iterador(this);
        return it.countingPrevious(this); // conte quantas vezes consegue chamar o parente.
    }
    */
    public void printChildren() { //imprime os filhos e suas informações, se possível
        try {
            System.out.println("l: " + this.getLeft().getName() + " | Value: " + this.getLeft().getValue() + " | Object: " + this.getLeft());
        } catch (Exception e) {
            System.out.println("l: Empty");
        }
        try {
            System.out.println("r: " + this.getRight().getName() + " | Value: " + this.getRight().getValue() + " | Object: " + this.getRight());
        } catch (Exception e) {
            System.out.println("r: Empty");
        }    
    }
    
    public boolean addChildSide(char side) {
        
        Node newNode = new Node();
        boolean success = false;
        
        
        switch(side){
            
            case 'l':
                if (this.left == null){
                    success = true;
                    this.setLeft(newNode);
                }
                break;
                
            case 'r':
                if (this.left == null){
                    success = true;
                    this.setRight(newNode);
                }
                break;
            
            default:
                success = false;
        }
        
        return success;
        
    }

    public void addChild() { //adiciona novo filho, da esquerda para a direita.
        
        Node newNode = new Node();
        
        if (this.left == null){
            this.setLeft(newNode);
        }

        else if(this.right == null){
            this.setRight(newNode);
        }
        
        else{
            System.err.println("No available space");
        }
        
    }
}
