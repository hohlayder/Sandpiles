//import static java.lang.Math.min;
//
//public class TypeSpill {
//
//    Paint paint;
//    public int[][] tab_change;
//    int N;
//
//    public TypeSpill(int N) {
//        paint = new Paint();
//        paint.setColor(Color.BLACK);
//        paint.setStrokeWidth(30.0f/N);
//        tab_change = new int[N][N];
//        this.N=N;
//    }
//    public void change(float x_touch, float y_touch, int parameter){
//        float length = min(width, height);
//        float startx = width/2.0f-length/2.0f, starty = height/2.0f-length/2.0f;
//        float pix_size=length/N;
//        tab_change[(int)((x_touch-startx)/pix_size)][(int)((y_touch-starty)/pix_size)]+=parameter;
//    }
//    public void draw(Canvas canvas){
//        float length = min(width, height);
//        float startx = width/2.0f-length/2.0f, starty = height/2.0f-length/2.0f;
//        float pix_size=length/N;
//        for(int y=0; y<=N; y++){
//            canvas.drawLine(startx, starty+y*pix_size, startx+length, starty+y*pix_size, paint);
//        }
//        for(int x=0; x<=N; x++){
//            canvas.drawLine(startx+x*pix_size, starty, startx+x*pix_size, starty+length, paint);
//        }
//    }
//}
