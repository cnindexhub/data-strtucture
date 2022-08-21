package com.dpf.datastrtucture;

import java.io.*;

/**
 * @author DengPengFei
 * @Description
 * @email ocq@qq.com
 * @date 2022-08-20 22:38
 */
public class SparseArray {

    public static void main(String [] args) {

        // 棋盘游戏 存档操作的棋局状态数据保存 通过稀疏数组对数据进行压缩
        // 0: 代表为走棋 1：代表黑棋 2：蓝棋
        int line = 11;
        int column = 11;
        int [][] chessArray1 = new int [line][column];



        chessArray1[5][1] = 2;
        chessArray1[10][6] = 1;
        chessArray1[7][5] = 1;
        chessArray1[5][5] = 1;

        // 存档时的棋盘图
        System.out.println("当前棋局状态：");
        for (int i = 0; i < line; i++) {
            for(int j = 0; j < column; j++) {
                System.out.printf("%d\t", chessArray1[i][j]);
            }
            System.out.println();
        }

        // 获取棋局不为0的个数
        int nonZeroSize = 0;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
               if (chessArray1[i][j] != 0){
                   nonZeroSize ++;
               }
            }
        }

        // 创建稀疏数组
        int[][] sparseArray = new int[nonZeroSize + 1][3];
        // 初始化稀疏数组第一行 保存原棋盘的行数和列数以及不为0的个数
        sparseArray[0][0] = line;
        sparseArray[0][1] = column;
        sparseArray[0][2] = nonZeroSize;
        // 将不为0的值及其坐标位置保存在第1行之后
        int index = 1;
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < column; j++) {
                if (chessArray1[i][j] != 0) {
                    sparseArray[index][0] = i;
                    sparseArray[index][1] = j;
                    sparseArray[index][2] = chessArray1[i][j];
                    index++;
                }
            }
        }

        // 将稀疏数组结果写入到文件map.data中
        // 从文件map.data中读取稀疏数组数据
        // 将稀疏数组还原为原棋盘数据

        line = sparseArray[0][0];
        column = sparseArray[0][1];
        int whileSize = sparseArray[0][2];
        int[][] chessArray2 = new int[line][column];
        for (int i = 1; i <= whileSize; i++) {
            for (int j = 0; j < 3; j++) {
                int x = sparseArray[i][0];
                int y = sparseArray[i][1];
                int chessType = sparseArray[i][2];
                chessArray2[x][y] = chessType;
            }
        }

        // 存档时的棋盘图
        System.out.println("还原后棋局状态：");
        for (int i = 0; i < line; i++) {
            for(int j = 0; j < column; j++) {
                System.out.printf("%d\t", chessArray2[i][j]);
            }
            System.out.println();
        }
    }

}
