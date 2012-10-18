import java.util.List;
import java.util.ArrayList;

//! Singleton
//! Conjunto de nohs do tipo GraphicElement
//! segue padrao Singleton
class NodePool {

    List<GraphicElement> nodes = new ArrayList<GraphicElement>();;

    static NodePool n =  null;

    public static NodePool getInstance() {
        if(n == null)
            return new NodePool();
        return n;
    }

    private NodePool() { }

    public void addNode(GraphicElement e) {
        nodes.add(e);
    }

    public List<GraphicElement> getElements() {
        return nodes;
    }
}


