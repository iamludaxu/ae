package gift.witch.android.ae.guava;


import com.google.common.graph.MutableValueGraph;
import com.google.common.graph.ValueGraphBuilder;

import org.junit.Test;

/**
 */
public class GuavaGraphTest {

    MutableValueGraph<Integer, String> graph;

    @Test
    public void directedGraph() {
        graph = ValueGraphBuilder.directed().allowsSelfLoops(true).build();
        graph.putEdgeValue(1, 2, "valueA");
        graph.putEdgeValue(2, 1, "valueB");
        graph.putEdgeValue(2, 3, "valueC");
        graph.putEdgeValue(4, 4, "valueD");
        String ss = graph.edges().toString();
        System.out.println(ss);
        /*
        assertThat(graph.edgeValue(1, 2)).isEqualTo("valueA");
        assertThat(graph.edgeValue(2, 1)).isEqualTo("valueB");
        assertThat(graph.edgeValue(2, 3)).isEqualTo("valueC");
        assertThat(graph.edgeValue(4, 4)).isEqualTo("valueD");
*/
        String toString = graph.toString();
        System.out.print(toString);
        /*
        assertThat(toString).contains("valueA");
        assertThat(toString).contains("valueB");
        assertThat(toString).contains("valueC");
        assertThat(toString).contains("valueD");
        */
    }


}
