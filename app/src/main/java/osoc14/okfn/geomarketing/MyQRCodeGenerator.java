package osoc14.okfn.geomarketing;

import android.graphics.Bitmap;
import android.graphics.Color;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

/**
 * Created by Samuel on 05/07/14.
 */
public class MyQRCodeGenerator {

    private int matrixWidth = 300;
    private QRCodeWriter writer = new QRCodeWriter();


    public Bitmap getQRBitmap(String qrCodeString) {

        try {
            BitMatrix matrix = writer.encode(qrCodeString, BarcodeFormat.QR_CODE, matrixWidth, matrixWidth);
            Bitmap mBitmap = Bitmap.createBitmap(matrixWidth, matrixWidth, Bitmap.Config.ARGB_8888);

            for (int i = 0; i < matrixWidth; i++) {
                for (int j = 0; j < matrixWidth; j++) {
                    mBitmap.setPixel(i, j, matrix.get(i, j) ? R.drawable.purple: Color.WHITE);
                }
            }

            return mBitmap;

        } catch (WriterException e) {
            e.printStackTrace();
            return null;
        }


    }

    public int getMatrixWidth() {
        return matrixWidth;
    }

    public void setMatrixWidth(int matrixWidth) {
        this.matrixWidth = matrixWidth;
    }
}
