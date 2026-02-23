import java.util.ArrayList;

public class GrafoMatriz {

    private int[][] matriz;
    private ArrayList<String> vertices;
    private int maxVertices;
    private int numVertices;


    public GrafoMatriz(int maxVertices) {
        this.maxVertices = maxVertices;
        this.numVertices = 0;
        matriz = new int[maxVertices][maxVertices];
        vertices = new ArrayList<>();
    }


    public void agregarVertice(String nombre) {
        if (numVertices < maxVertices) {
            vertices.add(nombre);
            numVertices++;
        } else {
            System.out.println("Límite de vértices alcanzado.");
        }
    }


    public void agregarArista(String origen, String destino) {
        int i = vertices.indexOf(origen);
        int j = vertices.indexOf(destino);

        if (i != -1 && j != -1) {
            matriz[i][j] = 1;
            matriz[j][i] = 1;
        } else {
            System.out.println("Uno de los vértices no existe.");
        }
    }


    public void mostrarMatriz() {
        System.out.println("MATRIZ DE ADYACENCIA\n");


        System.out.print("   ");
        for (String v : vertices) {
            System.out.print(v + " ");
        }
        System.out.println();


        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices.get(i) + " ");
            for (int j = 0; j < numVertices; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        GrafoMatriz grafo = new GrafoMatriz(4);


        grafo.agregarVertice("A");
        grafo.agregarVertice("B");
        grafo.agregarVertice("C");
        grafo.agregarVertice("D");


        grafo.agregarArista("A", "B");
        grafo.agregarArista("B", "C");
        grafo.agregarArista("C", "D");
        grafo.agregarArista("D", "A");


        grafo.mostrarMatriz();
    }


}
