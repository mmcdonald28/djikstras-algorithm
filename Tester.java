import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Tester
{

    public static void main(String[] args) throws FileNotFoundException
    {

        // Variables
        File myFile;
        Scanner scan = new Scanner(System.in);
        int numOfNodes = 0;
        int numOfEdges = 0;
        AdjacencyList adjList;

        // Begin process of reading in initial file
        System.out.println("Please enter the file you would like to read in");
        String fileName = scan.nextLine();
        myFile = new File(fileName);

        // Seeing if the file exists
        while (!myFile.exists())
        {
            System.out.println("File doesn't exist! Please enter the file you would like to read in");
            fileName = scan.nextLine();
            myFile = new File(fileName);
        }

        // Scanner obj to read in file
        Scanner fileScan = new Scanner(myFile);

        // Reading in first two lines
        numOfNodes = fileScan.nextInt();
        numOfEdges = fileScan.nextInt();
        adjList = new AdjacencyList(numOfNodes);

        // Reading in all other lines
        while (fileScan.hasNextLine())
        {
            int from, to, weight;
            from = fileScan.nextInt();
            to = fileScan.nextInt();
            weight = fileScan.nextInt();
            adjList.insert(from, to, weight);
        }
        fileScan.close();

        System.out.println("The adjacency list:");
        adjList.display();

        Scanner s = new Scanner(System.in);
        int choice;
        DjikstrasAlgorithm djik = new DjikstrasAlgorithm();

        System.out.println("""              
                Dijkstra’s Algorithm! Press the following: 
                1. To find the shortest path
                2. To output DFS and BFS
                3. To Exit""");

        choice = scan.nextInt();

        while (choice != 3) {
            switch (choice) {
                case 1:
                    djik.djikstras(numOfNodes, adjList, 0);
                    break;
                case 2:
                    djik.DFS(adjList);
                    djik.BFS(adjList);
                    break;
                case 3:
                    break;
            }
            System.out.println("""
                    1. To find the shortest path
                    2. To output DFS and BFS
                    3. To Exit""");

            choice = scan.nextInt();
        }
    }

}