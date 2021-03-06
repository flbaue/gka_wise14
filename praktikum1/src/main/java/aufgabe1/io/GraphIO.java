package aufgabe1.io;

import aufgabe1.Vertex;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.io.File;

/**
 * Created by flbaue on 20.10.14.
 */
public class GraphIO {

    private GraphLoader loader = new GraphLoader();
    private GraphSaver saver = new GraphSaver();

    public Graph<Vertex, DefaultWeightedEdge> readGraphFromFile(File path) {
        if (path.exists() && path.isFile()) {
            return loader.fromFile(path);
        }
        throw new IllegalArgumentException("file does not exist");
    }

    public void saveGraphAsFile(Graph<Vertex, DefaultWeightedEdge> graph, File path) {
        if (path.isDirectory()) {
            throw new IllegalArgumentException("path is not a file");
        }

        if (path.exists()) {
            path.delete();
        }

        saver.asFile(graph, path);
    }
}
