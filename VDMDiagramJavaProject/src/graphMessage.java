import org.jgrapht.graph.DefaultEdge;


public class graphMessage extends DefaultEdge
    {
        private String label;
        public void MyLabel(String label)
        {
            this.label = label;
        }

        @Override
        public String toString()
        {
            return label;
        }
    }
