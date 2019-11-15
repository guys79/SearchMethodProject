import Problem.BoardProblem;
import Problem.IProblem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The problem Creator, uses Singleton DP
 */
public class ProblemCreator  {
    private static ProblemCreator problemCreator;
    private List<int []> scenarios;
    private int index;
    private int [][] grid;

    /**
     * The constructor of the class
     */
    private ProblemCreator()
    {
        this.index = 0;
    }

    /**
     * This function will return the next problem
     * @return - The problem
     */
    public IProblem next()
    {
        if(index == scenarios.size())
            index = 0;
        int [] scen = scenarios.get(index);
        IProblem problem = new BoardProblem(scen[0],scen[1],scen[2],scen[3],grid);
        this.index++;
        return problem;
    }

    /**
     * This function will return the next scenario
     * @param mpPath - The path to the map file
     * @param scenarioPath - The path tot he scenario file
     * @return - The problem
     */
    public IProblem next(String mpPath,String scenarioPath)
    {


        index = 0;
        getGraph(mpPath);
        getScenarios(scenarioPath);
        return next();
    }
    /**
     * This function wil return the instance of the class
     * @return - The instance of the class
     */
    public static ProblemCreator getInstance()
    {
        if(problemCreator == null)
        {
            problemCreator = new ProblemCreator();
        }
        return problemCreator;
    }



    /**
     * This function will import the graph from the file
     * @param path - The path to the file
     * @return - The graph
     */
    private int [][] getGraph(String path)
    {
        Set<String> names = new HashSet<>();

        names.add("arena");
        names.add("arena2");
        names.add("ost003d");
        names.add("den312d");
        names.add("den520d");
        names.add("brc000d");
        names.add("brc200d");
        names.add("brc100d");
        names.add("brc101d");
        names.add("brc300d");
        names.add("ht_chantry");
        names.add("lak303d");
        names.add("ht_mansion_n");
        names.add("lt_gallowstemplar_n");
        boolean canT = true;
        for(String str:names)
        {
            if(path.contains(str))
            {

                canT = false;
                break;
            }
        }

        BufferedReader br = null;
        String line="";
        int[][] grid = null;
        try {

            br = new BufferedReader(new FileReader(path));
            line = br.readLine();//No use

            line = br.readLine();//Height size
            int height = Integer.parseInt(line.split(" ")[1]);

            line = br.readLine();//Width size
            int width = Integer.parseInt(line.split(" ")[1]);

            line = br.readLine();//useless

            grid = new int[height][width];



            for(int i=0;i<height;i++) {

                line = br.readLine();
                for(int j=0;j<width;j++) {

                    if(line.charAt(j)=='.' || line.charAt(j)=='G' || (line.charAt(j)=='T' && canT))
                        grid[i][j] = 1;
                    else {
                        grid[i][j] = 0;
                    }
                }
            }



        }catch (Exception e)
        {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        return grid;
    }
    /**
     * This function will import the scenarios from the file
     * @param path - The path to the file
     */
    private void getScenarios(String path)
    {
        BufferedReader br = null;
        String line;
        List<String> scen = new ArrayList<>();

        try {


            br = new BufferedReader(new FileReader(path));
            line = br.readLine();//No use

            while((line = br.readLine())!=null) {
                scen.add(line);
            }
            // TODO: 14/11/2019 Get Scenarios (The comments section needs to be fixed)
          /*  scenarios = new String[scen.size()][6];
            for(int i=0;i<this.scenarios.length;i++)
            {

                scenarios[i] = this.parseScenerio(scen.get(i));
            }
        */


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }



    }
}
