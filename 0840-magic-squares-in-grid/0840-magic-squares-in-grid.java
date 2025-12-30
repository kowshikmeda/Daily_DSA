class Solution {
    public int numMagicSquaresInside(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        if (n<3 || m<3) return 0;
        int[][] row = new int[n][m];
        int[][] col = new int[n][m];
        int[][] dia = new int[n][m];
        int[][] diar = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                int rj = m-j-1;
                if (j==0) {
                    row[i][j] = mat[i][j];
                } else row[i][j] = mat[i][j] + row[i][j-1];
                if (i==0 || j==0) {
                    dia[i][j] = mat[i][j];
                } else dia[i][j] = mat[i][j] + dia[i-1][j-1];
                if (i==0 || rj==m-1) {
                    diar[i][rj] = mat[i][rj];
                } else diar[i][rj] = mat[i][rj] + diar[i-1][rj+1];
            }
        }
        for (int j=0; j<m; j++) {
            for (int i=0; i<n; i++) {
                if (i==0) {
                    col[i][j] = mat[i][j];
                } else col[i][j] = mat[i][j] + col[i-1][j];
            }
        }
        int ans = 0;
        for (int i = 2; i<n; i++) {
            for (int j = 2; j<m; j++) {
                int sum = row[i][j] - (j!=2?row[i][j-3]:0);

                int nextsum;
                boolean flag = true;
                Set<Integer> set = new HashSet<>();

                for (int ii=i-2; ii<=i; ii++) {
                    for (int jj=j-2; jj<=j; jj++) {
                        if (mat[ii][jj]<1 || mat[ii][jj]>9 || set.contains(mat[ii][jj])) {
                            flag=false;
                            break;
                        } set.add(mat[ii][jj]);
                    } if (!flag) break;
                }

                for (int k=i; k>=i-2 && flag; k--) {
                    nextsum = row[k][j] - (j!=2?row[k][j-3]:0);
                    if (nextsum!=sum){
                        flag = false; break;
                    }
                }
                for (int k=j; k>=j-2 && flag; k--) {
                    nextsum = col[i][k] - (i!=2?col[i-3][k]:0);
                    if (nextsum!=sum){
                        flag = false; break;
                    }
                }
                if (flag) {
                    nextsum = dia[i][j] - ((j!=2 && i!=2)?dia[i-3][j-3]:0);
                    if (nextsum!=sum){
                        flag = false;
                    }
                }
                if (flag) {
                    nextsum = diar[i][j-2] - ((j+1<m && i!=2)?diar[i-3][j+1]:0);
                    if (nextsum!=sum){
                        flag = false;
                    }
                }
                if (flag) ans++;
            }
        }
        return ans;
    }
}