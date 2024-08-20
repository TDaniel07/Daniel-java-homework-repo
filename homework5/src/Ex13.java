import java.io.File;
import java.io.FileNotFoundException;
import java.util.Queue;
import java.util.Scanner;

//pentru acest exercitiu puteam sa folosesc un queue oferit de libraria standard
//java dar pentru a exersa sintaxa java am ales sa imi fac propiul queue.

class Position{

    public int x;

    public int y;

    public int parentIndex;

    Position(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class PositionQueue{

    public Position[] queue;

    public int frontIndex = 0;

    public int backIndex = 0;

    PositionQueue(int size){
        queue = new Position[size];
    }

    Position front(){
        Position tempPos = new Position(queue[frontIndex].x, queue[frontIndex].y);
        tempPos.parentIndex = queue[frontIndex].parentIndex;
        return tempPos;
    }

    void push(Position input){
        Position tempPos = new Position(input.x, input.y);
        tempPos.parentIndex = input.parentIndex;
        queue[backIndex] = tempPos;
        backIndex++;
    }

    void pop(){
        frontIndex++;
    }

    boolean empty(){
        return frontIndex == backIndex;
    }
}

class Maze{
    public char[][] matrix;
    public boolean[][] visitedCells;
    public int rows;
    public int columns = -1;
    public Position start;
    public Position end;

    Maze(int maxRows, int maxColumns){
        this.matrix = new char[maxRows][maxColumns];
        this.visitedCells = new boolean[maxRows][maxColumns];
    }

    void print(){
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++)
                System.out.print(matrix[i][j] + " ");

            System.out.print("\n");
        }
    }
    boolean canEnterCell(Position pos){
        return this.matrix[pos.x][pos.y] == '0' && !this.visitedCells[pos.x][pos.y];
    }

    boolean isInsideMaze(Position pos) {
        return pos.x >= 0 && pos.x < this.rows && pos.y >= 0 && pos.y < this.columns;
    }

    boolean reachedEndOfMaze(Position pos){
        return pos.x == this.end.x && pos.y == this.end.y;
    }

    void printSolvedMaze(Position finalPos, PositionQueue q){
        int index = -1;
        Position pos = new Position(finalPos.x, finalPos.y);
        pos.parentIndex = finalPos.parentIndex;

        do{
            if(index != -1)
                pos = q.queue[index];
            this.matrix[pos.x][pos.y] = '*';
            index = pos.parentIndex;
        }while(index != 0);

        this.print();
    }
}

public class Ex13 {
    //se pare ca pentru a folosi scanner cu fisiere trebuie sa adaug o sintaxa
    //speciala pentru erori, am ales sa o folosesc pentru ca exercitiul spune ca labirintul
    //poate fi citit dintr-un fisier si mi s-a parut mai interesant asa.

    static void fillMaze(Maze maze) throws FileNotFoundException {
        Scanner inputScanner = new Scanner((new File("src/input.txt")));
        String mazeLine;
        int row = 0, column;

        while(inputScanner.hasNextLine()){
            mazeLine = inputScanner.nextLine();
            column = 0;

            for(int i = 0; i < mazeLine.length(); i++) {
                char mazeLinePosition = mazeLine.charAt(i);

                switch (mazeLinePosition) {
                    case '1', '0' -> {
                        maze.matrix[row][column] = mazeLinePosition;
                        column++;
                    }
                    case 'S' -> {
                        maze.matrix[row][column] = '*';
                        maze.start = new Position(row, column);
                        column++;
                    }
                    case 'E' -> {
                        maze.matrix[row][column] = '0';
                        maze.end = new Position(row, column);
                        column++;
                    }
                }
            }
            if(maze.columns == -1)
                maze.columns = column;
            row++;
        }
        maze.rows = row;
    }


    //am asumat ca nu vor fi mai mult de un milion de intrari in queue ceea ce
    //avand in vedere ca am asumat ca vor fi maximum 100 de linii si coloane
    //nu vor putea fi mai mult de 100 * 100 = 10000 de posibilitati de a parcurge
    //labirintul in cel mai rau caz
    static void solveMaze(Maze maze){
        Position currentPosition = maze.start;
        Position nextPosition = new Position(0, 0);
        PositionQueue queue = new PositionQueue(10000000);
        boolean finishedMaze;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        currentPosition.parentIndex = 0;
        queue.push(currentPosition);
        finishedMaze = false;

        while(!finishedMaze && !queue.empty()){
            currentPosition = queue.front();
            queue.pop();

            if(maze.reachedEndOfMaze(currentPosition)){
                finishedMaze = true;
                continue;
            }

            for(int i = 0; i < 4; ++i){
                nextPosition.x = currentPosition.x + dx[i];
                nextPosition.y = currentPosition.y + dy[i];
                nextPosition.parentIndex = queue.frontIndex -1;

                if(maze.isInsideMaze(nextPosition) && maze.canEnterCell(nextPosition)){
                    maze.visitedCells[nextPosition.x][nextPosition.y] = true;
                    queue.push(nextPosition);
                }
            }
        }

        if(!finishedMaze)
            System.out.println("No solution found.");
        else
            maze.printSolvedMaze(currentPosition, queue);
    }

    public static void main(String[] args) throws FileNotFoundException {
        //pentru acest exercitiu am asumat ca un labirint poate avea
        //maximum 100 de linii si coloane
        Maze maze = new Maze(100, 100);

        fillMaze(maze);
        solveMaze(maze);


    }
}
