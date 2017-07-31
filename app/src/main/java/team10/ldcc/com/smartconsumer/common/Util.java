package team10.ldcc.com.smartconsumer.common;


import android.content.Context;
import android.content.DialogInterface;

import android.os.Build;

import android.support.v7.app.AlertDialog;

import android.widget.TextView;

import team10.ldcc.com.smartconsumer.R;


/**
 * Created by service-dev on 2016. 12. 6..
 */

public class Util {
//    public final static int ANIM_LEFT_IN = 0;
//    public final static int ANIM_RIGHT_IN = 1;
//    public final static int ANIM_LEFT_OUT = 2;
//    public final static int ANIM_RIGHT_OUT = 3;

    /**
     * getColor deprecated 대응
     *
     * @param context
     * @param id      res color R ex) R.color.your_color
     * @return
     */
    public static int getColor(Context context, int id) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return context.getColor(id);
        } else {
            return context.getResources().getColor(id);
        }
    }
//
//    /**
//     * getDrawable deprecated 대응
//     *
//     * @param context
//     * @param id      res drawable R ex) R.drawable.your_drawable
//     * @return
//     */
//    public static Drawable getDrawable(Context context, int id) {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            return context.getDrawable(id);
//        } else {
//            return context.getResources().getDrawable(id);
//        }
//    }
//
//
//    /**
//     * 롤리팝 이전 버전 그림자 보여주기
//     *
//     * @param activity
//     */
//    public static void shadowVisible(Activity activity) {
//        View view = activity.findViewById(R.id.toolbar_shadow);
//        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            view.setVisibility(View.VISIBLE);
//        } else {
//            view.setVisibility(View.GONE);
//        }
//    }
//
//
//    /**
//     * startActivity, finish 때 애니메이션 설정
//     */
//    public static void activityAnimation(Activity activity, int inAnim, int outAnim) {
//        int inAnimResource = 0;
//        int outAnimResource = 0;
//
//        switch (inAnim) {
//            case ANIM_LEFT_IN:
//                inAnimResource = R.anim.anim_slide_in_left;
//                break;
//            case ANIM_LEFT_OUT:
//                inAnimResource = R.anim.anim_slide_out_left;
//                break;
//            case ANIM_RIGHT_IN:
//                inAnimResource = R.anim.anim_slide_in_right;
//                break;
//            case ANIM_RIGHT_OUT:
//                inAnimResource = R.anim.anim_slide_out_right;
//                break;
//            default:
//                inAnimResource = -1;
//                break;
//        }
//        switch (outAnim) {
//            case ANIM_LEFT_IN:
//                outAnimResource = R.anim.anim_slide_in_left;
//                break;
//            case ANIM_LEFT_OUT:
//                outAnimResource = R.anim.anim_slide_out_left;
//                break;
//            case ANIM_RIGHT_IN:
//                outAnimResource = R.anim.anim_slide_in_right;
//                break;
//            case ANIM_RIGHT_OUT:
//                outAnimResource = R.anim.anim_slide_out_right;
//                break;
//            default:
//                outAnimResource = -1;
//                break;
//        }
//        if (outAnimResource > 0 && inAnimResource > 0) {
//            activity.overridePendingTransition(inAnimResource, outAnimResource);
//        }
//    }
//
//
//    /**
//     * 확인만 있는 알럿
//     */
//
    public static AlertDialog alertMsg(Context context, String msg, DialogInterface.OnClickListener yesListener) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context,R.style.AlertDialog);
        alert.setTitle("알림");
        alert.setPositiveButton("확인", yesListener);
        alert.setMessage(msg);
        AlertDialog dialog =  alert.show();
        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
        messageView.setLineSpacing(context.getResources().getDimension(R.dimen.default_text_line_height_size),1.0f);
        return dialog;
    }
//
//    /**
//     * 확인만 있는 알럿(필수)
//     */
//
//    public static AlertDialog alertNecessaryMsg(Context context,String title, String msg, DialogInterface.OnClickListener yesListener, DialogInterface.OnDismissListener dismissListener) {
//        AlertDialog.Builder alert = new AlertDialog.Builder(context,R.style.AlertDialog);
//        alert.setTitle("알림");
//        alert.setPositiveButton("확인", yesListener);
//        alert.setMessage(msg);
//        alert.setOnDismissListener(dismissListener);
//
//
//        AlertDialog dialog =  alert.show();
//        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
//        messageView.setLineSpacing(context.getResources().getDimension(R.dimen.default_text_line_height_size),1.0f);
//        return dialog;
//    }
//
//    /**
//     * 확인만 있는 알럿
//     */
//    public static AlertDialog alertTitleMsg(Context context, String title, String msg, DialogInterface.OnClickListener yesListener) {
//        AlertDialog.Builder alert = new AlertDialog.Builder(context,R.style.AlertDialog);
//        alert.setTitle(title);
//        alert.setPositiveButton("확인", yesListener);
//        alert.setMessage(msg);
//        AlertDialog dialog =  alert.show();
//        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
//        messageView.setLineSpacing(context.getResources().getDimension(R.dimen.default_text_line_height_size),1.0f);
//        return dialog;
//    }
//    /**
//     * 확인 취소 있는 알럿
//     */
//
    public static AlertDialog alertYesNoMsg(Context context, String title, String msg, DialogInterface.OnClickListener yesListener,DialogInterface.OnClickListener noListener) {
        AlertDialog.Builder alert = new AlertDialog.Builder(context, R.style.AlertDialog);
        alert.setTitle(title);
        alert.setPositiveButton("확인", yesListener);
        alert.setNegativeButton("취소",noListener);
        alert.setMessage(msg);
        AlertDialog dialog =  alert.show();
        TextView messageView = (TextView)dialog.findViewById(android.R.id.message);
        messageView.setLineSpacing(context.getResources().getDimension(R.dimen.default_text_line_height_size),1.0f);
        return dialog;
    }
//
//
//    /**
//     * 커스텀 알럿
//     */
//
//    public static View customAlertMsg(Context context, @LayoutRes int layoutId) {
//        AlertDialog.Builder alert = new AlertDialog.Builder(context);
//        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//        View view = inflater.inflate(layoutId,null);
//        alert.setView(view);
//        AlertDialog dialog = alert.show();
//        view.setTag(dialog);
//        return view;
//    }
//
//
//    /**
//     * 프로그래스바 색깔 입히기
//     *
//     * @param progressBar
//     * @param color
//     */
//    public static void progressBarSetColor(ProgressBar progressBar, int color) {
//        progressBar.getIndeterminateDrawable().setColorFilter(color,
//                android.graphics.PorterDuff.Mode.SRC_ATOP);
//    }
//
//
//    /**
//     * 비트맵 돌아간 각도 알아오기
//     *
//     * @param exifOrientation
//     * @return
//     */
//    public static int exifOrientationToDegrees(int exifOrientation) {
//        if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_90) {
//            return 90;
//        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_180) {
//            return 180;
//        } else if (exifOrientation == ExifInterface.ORIENTATION_ROTATE_270) {
//            return 270;
//        }
//        return 0;
//    }
//
//
//    /**
//     * 이미지를 회전시킵니다.
//     *
//     * @param bitmap  비트맵 이미지
//     * @param degrees 회전 각도
//     * @return 회전된 이미지
//     */
//    public static Bitmap rotate(Bitmap bitmap, int degrees) {
//        if (degrees != 0 && bitmap != null) {
//            Matrix m = new Matrix();
//            m.setRotate(degrees, (float) bitmap.getWidth() / 2,
//                    (float) bitmap.getHeight() / 2);
//
//            try {
//                Bitmap converted = Bitmap.createBitmap(bitmap, 0, 0,
//                        bitmap.getWidth(), bitmap.getHeight(), m, true);
//                if (bitmap != converted) {
//                    bitmap.recycle();
//                    bitmap = converted;
//                }
//            } catch (OutOfMemoryError ex) {
//                // 메모리가 부족하여 회전을 시키지 못할 경우 그냥 원본을 반환합니다.
//            }
//        }
//        return bitmap;
//    }
//
//    /**
//     * 키보드 숨기기
//     *
//     * @param editText
//     */
//    public static void keyBoardHide(Context context, EditText editText) {
//        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.hideSoftInputFromWindow(editText.getWindowToken(), 0);
//    }
//
//    /**
//     * 키보드 띄우기
//     *
//     * @param context
//     */
//    public static void keyBoardShow(Context context, EditText editText) {
//        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
//        imm.showSoftInput(editText, InputMethodManager.SHOW_FORCED);
//    }
//
//    /**
//     * dp 값을 화면에 맞는 px 값으로 변경
//     *
//     * @param context
//     * @param dp
//     * @return
//     */
//    public static int convertDpToPx(Context context, float dp) {
//        float d = context.getResources().getDisplayMetrics().density;
//        return (int) (d * dp);
//    }
//
////    /**
////     * 레이팅바 색상 변경
////     *
////     * @param ratingBar
////     * @param color
////     */
////    public static void setRatingBarColor(RatingBar ratingBar, int color, Context context) {
////        LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
////        stars.getDrawable(2).setColorFilter(color, PorterDuff.Mode.SRC_ATOP);
////        stars.getDrawable(1).setColorFilter(getColor(context, R.color.colorBorderLine), PorterDuff.Mode.SRC_ATOP);
////        stars.getDrawable(0).setColorFilter(getColor(context, R.color.colorEmpty), PorterDuff.Mode.SRC_ATOP);
////    }
//
//    /**
//     * statusbar 크기
//     *
//     * @param context
//     * @return
//     */
//    public static int getStatusBarHeight(Context context) {
//        int result = 0;
//        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
//        if (resourceId > 0) {
//            result = context.getResources().getDimensionPixelSize(resourceId);
//        }
//        return result;
//    }
//
//    /**
//     * 파일 사이즈 변경
//     *
//     * @param size file byte
//     * @return
//     */
//    public static String readableFileSize(long size) {
//        if (size <= 0) return "0";
//        final String[] units = new String[]{"B", "kB", "MB", "GB", "TB"};
//        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));
//        return new DecimalFormat("#,##0.#").format(size / Math.pow(1024, digitGroups)) + " " + units[digitGroups];
//    }
//
//    /**
//     * string 형 날짜 date 변환
//     *
//     * @param form    변환할 문자 상태와 동일 한 데이트 형태 (ex yyyy-MM-dd or yyyy.MM.dd)
//     * @param dateStr 변환 문자
//     * @return
//     */
//    public static Date stringToDate(String form, String dateStr) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat(form);
//        try {
//            Date date = dateFormat.parse(dateStr);
//            return date;
//        } catch (ParseException e) {
//            return null;
//        }
//    }
//
//    /**
//     * 앱 버전 정보
//     * @param context
//     * @return
//     */
//    public static String appVersion(Context context){
//        PackageInfo pi = null;
//        try {
//            pi = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return pi.versionName;
//    }
//
//    /**
//     * 스크롤 위치  view 위치로 이동
//     *
//     * @param view
//     * @param scrollView
//     */
//    public static void nestedScrollToView(View view, final NestedScrollView scrollView) {
//        nestedScrollToView(view, scrollView, 0);
//    }
//
//    public static void nestedScrollToView(View view, final NestedScrollView scrollView, int count) {
//        if (view != null && view != scrollView) {
//            count += view.getTop();
//            nestedScrollToView((View) view.getParent(), scrollView, count);
//        } else if (scrollView != null) {
//            final int finalCount = count;
//            new Handler().postDelayed(new Runnable() {
//                @Override
//                public void run() {
//                    scrollView.smoothScrollTo(0, finalCount);
//                }
//            }, 200);
//        }
//    }
//
//    /**
//     * db 체크
//     * @param mContext
//     * @param dbName
//     * @return
//     */
//    public static boolean isCheckDB(Context mContext,String dbName){
//        String filePath = "/data/data/" + mContext.getPackageName()+ "/databases/" +dbName;
//
//
//        File file = new File(filePath);
//        if (file.exists()) {
//            return true;
//        }
//        return false;
//    }
//
//    /**
//     * db 복사
//     * @param mContext
//     * @param dbName
//     * @return
//     */
//    public static void copyDB(Context mContext,String dbName){
//        AssetManager manager = mContext.getAssets();
//        String folderPath = "/data/data/" + mContext.getPackageName() + "/databases";
//        String filePath = "/data/data/" +mContext.getPackageName() + "/databases/" + dbName;
//        File folder = new File(folderPath);
//        File file = new File(filePath);
//        FileOutputStream fos = null; BufferedOutputStream bos = null;
//        try {
//            InputStream is = manager.open("db/"+dbName);
//            BufferedInputStream bis = new BufferedInputStream(is);
//            if (folder.exists()) { }else{ folder.mkdirs(); }
//            if (file.exists()) {
//                file.delete();
//                file.createNewFile();
//            }
//            fos = new FileOutputStream(file); bos = new BufferedOutputStream(fos);
//            int read = -1;
//            byte[] buffer = new byte[1024];
//            while ((read = bis.read(buffer, 0, 1024)) != -1) {
//                bos.write(buffer, 0, read);
//            }
//            bos.flush();
//            bos.close();
//            fos.close();
//            bis.close();
//            is.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }	}
}
