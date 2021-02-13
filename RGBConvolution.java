/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgisleme;

import cezeri.matrix.CMatrix;
import java.awt.Color;

/**
 *
 * @author YUSUFNAS
 */
public class RGBConvolution {

    public static void main(String[] args) {

        String path = "D:\\images\\picture_1.jpg";
        
        double[][] d = {
            {1, 4, 7, 4, 1},
            {4, 16, 26, 16, 4},
            {7, 26, 41, 26, 27},
            {4, 16, 26, 16, 4},
            {1, 4, 7, 4, 1}
        };
        //RED
        CMatrix cmred = CMatrix.getInstance(d).imread(path).heatmap(Color.RED, 400, 400);
        CMatrix red_cnv2 = cmred.convolve(cmred);
//                .heatmap(Color.RED, 400, 400);
        CMatrix red_cnv3 = red_cnv2.convolve(red_cnv2);
//                .heatmap(Color.RED, 400, 400);
//        
        //GREEN
        CMatrix cmgreen = CMatrix.getInstance(d).imread(path).heatmap(Color.GREEN, 400, 400);
        CMatrix green_cnv2 = cmgreen.convolve(cmgreen);
//                .heatmap(Color.GREEN, 400, 400);
        CMatrix green_cnv3 = green_cnv2.convolve(green_cnv2);
//                .heatmap(Color.GREEN, 400, 400);

        //BLUE
        CMatrix cmblue = CMatrix.getInstance(d).imread(path).heatmap(Color.BLUE, 400, 400);
        CMatrix blue_cnv2 = cmblue.convolve(cmblue);
//                .heatmap(Color.BLUE, 400, 400);
        CMatrix blue_cnv3 = blue_cnv2.convolve(blue_cnv2);
//                .heatmap(Color.BLUE, 400, 400);

        CMatrix temp = red_cnv3.convolve(green_cnv3);
        temp = temp.convolve(blue_cnv3).heatmap();
    }
}
