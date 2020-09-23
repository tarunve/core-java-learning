package abdulbari.practice003.array;

/**
 *  Array location address formulae:
 *  -------------------------------
 *      Address(A[i]) = L0 + (i-1)*w
 *          where L0 = address of first element
 *                i  = index for which the address to be calculated
 *                w  = size of the data type (ex. for int - 2 bytes)
 *
 *  Row-Major Mapping :
 *  -----------------
 *  -   2D array is stored in single dimension array row-by-row i.e. first row data first
 *  -   Address(A[i][j]) = L0 + [i*n + j]*w            (if indices are string from 0)
 *      Address(A[i][j]) = L0 + [(i-1)*n + (j-1)]*w    (if indices are string from 1)
 *
 *  Column-Major Mapping:
 *  --------------------
 *  -   2D array is stored in single dimension array column-by-column.
 *  -   Address(A[i][j]) = L0 + [j*m + i]*w            (if indices are string from 0)
 *      Address(A[i][j]) = L0 + [(j-1)*m + (i-1)]*w    (if indices are string from 0)
 *
 *  3-dimension array:
 *  -----------------
 *  -   int A[l][m][n];
 *      -   Row Major Formulae :
 *              Address(A[i][j][k]) = L0 + [i*m*n + j*n + k]*w
 *      -   Column Major Formulae :
 *              Address(A[i][j][k]) = L0 + [k*l*m + j*l + i]*w
 *  4-dimension array:
 *  -----------------
 *  -   int A[d1][d2][d3][d4];
 *      -   Row Major Formulae :
 *              Address(A[i1][i2][i3][i4]) = L0 + [i1*d2*d3*d4 + i2*d3*d4 + i3*d4 + i4]*w
 *      -   Column Major Formulae :
 *              Address(A[i1][i2][i3][i4]) = L0 + [i4*d1*d2*d3 + i3*d1*d2 + i2*d1 + i1]*w
 */
public class T_003_MultiDimensionArray {

    public static void main(String[] args) {
        simple2DArray();
    }

    public static void simple2DArray() {
        int twoDimArr[][] = new int[3][4];
        twoDimArr[0][0] = 12;
        twoDimArr[0][1] = 12;
        twoDimArr[0][2] = 12;
        twoDimArr[0][3] = 12;
        twoDimArr[1][0] = 13;
        twoDimArr[1][1] = 13;
        twoDimArr[1][2] = 13;
        twoDimArr[1][3] = 13;
        twoDimArr[2][0] = 14;
        twoDimArr[2][1] = 14;
        twoDimArr[2][2] = 14;
        twoDimArr[2][3] = 14;

        for (int i=0; i<3; i++){
            for (int j=0; j<4; j++){
                System.out.print(twoDimArr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
