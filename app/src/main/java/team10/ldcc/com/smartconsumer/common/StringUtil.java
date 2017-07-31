package team10.ldcc.com.smartconsumer.common;

import android.content.Context;

import android.util.Log;




import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import team10.ldcc.com.smartconsumer.R;


/**
 * Created by service-dev on 2016. 2. 18..
 */
public class StringUtil {
    public StringUtil() {

    }

    /**
     * 문자를 입력 받아 정규식을 통하여 이메일 형식을 체크하여 결과를 반환 해준다.
     *
     * @param email 형식을 확인할 이메일 문자
     * @return 이메일 검사 결과 true or false;
     */
    public static boolean isEmailValid(Context context,String email) {
        boolean isValid = false;

        String expression = context.getString(R.string.pattern_email);
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
//    /**
//     * 문자를 입력 받아 정규식을 통하여 닉네임 형식을 체크하여 결과를 반환 해준다.
//     *
//     * @param nick 형식을 확인
//     * @return 닉네임 검사 결과 true or false;
//     */
//    public static boolean isNickValid(Context context,String nick) {
//        boolean isValid = false;
//
//        String expression = context.getString(R.string.pattern_nick);
//        CharSequence inputStr = nick;
//
//        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(inputStr);
//        if (matcher.matches()) {
//            if(nick.length()>=2 && nick.length()<=15) {
//                isValid = true;
//            }else {
//                isValid = false;
//            }
//        }
//        return isValid;
//    }
//    /**
//     * 문자를 입력 받아 정규식을 통하여 패스워드 형식을 체크하여 결과를 반환 해준다.
//     *
//     * @param pwStr 형식을 확인
//     * @return 패스워드 검사 결과 true or false;
//     */
//    public static boolean isPassValid(Context context, String pwStr) {
//        String expression = context.getString(R.string.pattern_pass);
//        CharSequence inputStr = pwStr;
//
//        Pattern pattern = Pattern.compile(expression,Pattern.CASE_INSENSITIVE);
//        Matcher matcher = pattern.matcher(inputStr);
//        if (matcher.matches()) {
//            return true;
//        }else {
//            return false;
//        }
//    }
//
//
    /**
     * SHA256 암호화
     *
     * @param str 암호화를 진행할 문자값
     * @return 암호화된 문자값
     */
    public static String changeSHA256(String str) {
        String SHA = "";
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-256");
            sh.update(str.getBytes());
            byte byteData[] = sh.digest();
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
            }
            SHA = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            Log.e("Exception", e.getMessage());
            SHA = null;
        }
        return SHA;
    }
//
    /**
     * int형 숫자를 금액 표기를 위한 천단위 표기 문자 형태로 변환 한다.
     *
     * @param price 변환 할 int형 정수 -> 10000
     * @return 변환 된 천단위 금액 문자 -> 10,000
     */
    public static String changePrice(int price) {
        DecimalFormat Commas = new DecimalFormat("#,###");
        String result_int = Commas.format(price);
        return result_int;
    }
//
//    /**
//     * 사진 촬영후 이미지 경로 반환
//     * @param context
//     * @param data
//     * @return
//     */
//    public static String getCameraImagePath(Context context, Intent data) {
//        String imagePath;
//        if (data.getData() != null) {
//            Uri imageUri = data.getData();
//            String[] projection = {MediaStore.Images.Media.DATA};
//            Cursor cursor = context.getContentResolver().query(imageUri, projection, null, null, null);
//            cursor.moveToFirst();
//            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
//            imagePath = cursor.getString(columnIndex);
//            cursor.close();
//        } else {
//            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//            ByteArrayOutputStream bytes = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
//            String path = MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), bitmap, "Title", null);
//            Uri imageUri = Uri.parse(path);
//            Cursor cursor = context.getContentResolver().query(imageUri, null, null, null, null);
//            cursor.moveToFirst();
//            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
//            imagePath = cursor.getString(idx);
//            cursor.close();
//        }
//        return imagePath;
//    }
//
    /**
     * 캘린더 객체를 가지고 0000년 00월00일(월) 형태로 데이터를 변환.
     *
     * @param calendar : 변환할 calendar
     * @return 0000년 00월00일(월)
     */
    public static String calendarToFullDateStr(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

        String toDateStr = calendar.get(Calendar.YEAR) + "년" + " " +
                (calendar.get(Calendar.MONTH) + 1) + "월" +
                calendar.get(Calendar.DAY_OF_MONTH) + "일" + "(" + dayOfWeek(dayOfWeek) + ")";

        return toDateStr;
    }
//
    /**
     * 캘린더의 int 형 요일 데이터를 한글로 변환.
     *
     * @param dayOfWeek : int 형 요일 데이터
     * @return 해당요일(예: 월)
     */
    public static String dayOfWeek(int dayOfWeek) {
        switch (dayOfWeek) {
            case 1:
                return "일";
            case 2:
                return "월";
            case 3:
                return "화";
            case 4:
                return "수";
            case 5:
                return "목";
            case 6:
                return "금";
            case 7:
                return "토";
        }
        return "";
    }
//
//    /**
//     * 캘린더 객체를 가지고 오전 00시 으로 형태로 변환.
//     *
//     * @param calendar : 변환할 calendar
//     * @return 오전 00시
//     */
//    public static String calendarTpTimeStr(Calendar calendar) {
//        int hour = calendar.get(Calendar.HOUR);
//        if (hour == 0) {
//            hour = 12;
//        }
//        String nowTimeStr = (calendar.get(Calendar.AM_PM) == 0 ? "오전" : "오후") + " " + hour + "시";
//        if (calendar.get(Calendar.MINUTE) > 0) {
//            nowTimeStr += " " + calendar.get(Calendar.MINUTE) + "분";
//        }
//        return nowTimeStr;
//    }
//
//    /**
//     * 캘린더 객체를 가지고 오전 00시 으로 형태로 변환.
//     *
//     * @param calendar : 변환할 calendar
//     * @return 오전 00:00
//     */
//    public static String calendarTpCloneTimeStr(Calendar calendar) {
//        StringBuffer buffer = new StringBuffer();
//        int hour = calendar.get(Calendar.HOUR);
//        if (hour == 0) {
//            hour = 12;
//        }
//        buffer.append((calendar.get(Calendar.AM_PM) == 0 ? "오전 " : "오후 "));
//        if(hour<10) {
//            buffer.append("0").append(hour);
//        }else {
//            buffer.append(hour);
//        }
//        buffer.append(":");
//
//
//        if (calendar.get(Calendar.MINUTE) >=10) {
//            buffer.append(calendar.get(Calendar.MINUTE)) ;
//        }else {
//            buffer.append("0").append(calendar.get(Calendar.MINUTE)) ;
//        }
//        return buffer.toString();
//    }
//
//
//    /**
//     *  string to date
//     * @return
//     */
//    public static Date stringToDate(String date,String format) throws ParseException {
//        SimpleDateFormat transFormat = new SimpleDateFormat(format);
//        return transFormat.parse(date);
//    }
//
//    /**
//     * int형 숫자를 금액 표기를 위한 천단위 표기 문자 형태로 변환 한다.
//     *
//     * @param won 변환 할 int형 정수 -> 10000
//     * @return 변환 된 천단위 금액 문자 -> 10,000
//     */
//    public static String commaWon(long won) {
//        DecimalFormat Commas = new DecimalFormat("#,###");
//        String result_int = Commas.format(won);
//        return result_int;
//    }
//
//    /**
//     * @return 8/8(월)
//     */
//    public static String calendarToMonthSlashText(Calendar calendar){
//        StringBuffer buffer = new StringBuffer();
//        buffer.append((calendar.get(Calendar.MONTH) + 1)).append("/").append(calendar.get(Calendar.DAY_OF_MONTH))
//                .append("(").append(dayOfWeek(calendar.get(Calendar.DAY_OF_WEEK))).append(")");
//        return buffer.toString();
//    }
//
//    /**
//     * @return 8/8
//     */
//    public static String calendarToMonthSlash(Calendar calendar){
//        StringBuffer buffer = new StringBuffer();
//        buffer.append((calendar.get(Calendar.MONTH) + 1)).append("/").append(calendar.get(Calendar.DAY_OF_MONTH));
//        return buffer.toString();
//    }
//
//    /**
//     *
//     * @return 8월 8일(월)
//     */
//    public static String calendarToMonthKorText(Calendar calendar){
//        StringBuffer buffer = new StringBuffer();
//        buffer.append((calendar.get(Calendar.MONTH) + 1)).append("월 ").append(calendar.get(Calendar.DAY_OF_MONTH)).append("일")
//                .append("(").append(dayOfWeek(calendar.get(Calendar.DAY_OF_WEEK))).append(")");
//        return buffer.toString();
//    }
//
//    /**
//     *
//     * @param s
//     * @param size
//     * @return string -> string...
//     */
//
//    public static String maxLengthText(String s, int size)
//    {
//        if(s.length() >size)
//        {
//            String temp = s.substring(0,size);
//            temp += "...";
//            return temp;
//        }
//        else {
//            return s;
//        }
//    }


}
