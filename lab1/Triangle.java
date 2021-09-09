public class Triangle {
    public static void drawTriangle(int size){
        int row = 0;
        int col;
        while(row < size){
            col = 0;
            while (col <= row){
                System.out.print('x');
                col = col + 1;
            }
            System.out.println();
            row = row + 1;
        }
    }

    public static void main(String[] args) {
        drawTriangle(6);
    }
}
