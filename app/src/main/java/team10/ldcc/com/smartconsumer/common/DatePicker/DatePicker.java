package team10.ldcc.com.smartconsumer.common.DatePicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;



import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import team10.ldcc.com.smartconsumer.R;


public class DatePicker extends LinearLayout implements NumberPicker.OnValueChangeListener {

    private LinearLayout select_layout;
    private TextView text_year, text_month, text_day;


    private NumberPicker mYearPicker;
    private NumberPicker mMonthPicker;
    private NumberPicker mDayOfMonthPicker;

    private Calendar mCalendar;

    private OnDateChangedListener mOnDateChangedListener;

    private LayoutInflater mLayoutInflater;

    private int thisYear, thisMonth, thisDay;
    private boolean setDateCheck = false;

    public DatePicker(Context context) {
        this(context, null);
    }

    public DatePicker(Context context, AttributeSet attrs) {
        super(context, attrs);
        mLayoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        init();
    }

    private void init() {
        mLayoutInflater.inflate(R.layout.date_picker_layout, this, true);
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(calendar.getTime());

        mYearPicker = (NumberPicker) findViewById(R.id.year_picker);
        mMonthPicker = (NumberPicker) findViewById(R.id.month_picker);
        mDayOfMonthPicker = (NumberPicker) findViewById(R.id.day_picker);

        thisYear = Integer.parseInt(date.substring(0, 4));
        thisMonth = Integer.parseInt(date.substring(4, 6));
        thisDay = Integer.parseInt(date.substring(6, 8));

        mYearPicker.setEndNumber(thisYear-1);
        mYearPicker.setStartNumber(1900);

/*        select_layout = (LinearLayout) findViewById(R.id.select_layout);*/

        mYearPicker.setOnValueChangeListener(this);
        mMonthPicker.setOnValueChangeListener(this);
        mDayOfMonthPicker.setOnValueChangeListener(this);

        if (!getResources().getConfiguration().locale.getCountry().equals("KR")
                && !getResources().getConfiguration().locale.getCountry().equals("KOR")) {

            String[] monthNames = getResources().getStringArray(R.array.month_number);
            mMonthPicker.setCustomTextArray(monthNames);

        }

        mCalendar = Calendar.getInstance();
        setDate(mCalendar.getTime());
    }

    public DatePicker setDate(Date date) {
        mCalendar.setTime(date);
        mDayOfMonthPicker.setEndNumber(mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        mYearPicker.setCurrentNumber(mCalendar.get(Calendar.YEAR));
        mMonthPicker.setCurrentNumber(mCalendar.get(Calendar.MONTH) + 1);
        mDayOfMonthPicker.setCurrentNumber(mCalendar.get(Calendar.DAY_OF_MONTH));

        return this;
    }

    @Override
    public void onValueChange(final NumberPicker picker, final int oldVal, final int newVal) {
        if (picker == mYearPicker) {
            int dayOfMonth = mCalendar.get(Calendar.DAY_OF_MONTH);
            mCalendar.set(newVal, mCalendar.get(Calendar.MONTH), 1);
            int lastDayOfMonth = mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (dayOfMonth > lastDayOfMonth) {
                dayOfMonth = lastDayOfMonth;
            }
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            mDayOfMonthPicker.setEndNumber(lastDayOfMonth);

        } else if (picker == mMonthPicker) {
            int dayOfMonth = mCalendar.get(Calendar.DAY_OF_MONTH);
            mCalendar.set(mCalendar.get(Calendar.YEAR), newVal - 1, 1);
            int lastDayOfMonth = mCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);
            if (dayOfMonth > lastDayOfMonth) {
                dayOfMonth = lastDayOfMonth;
            }
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            mDayOfMonthPicker.setEndNumber(lastDayOfMonth);
        } else if (picker == mDayOfMonthPicker) {
            mCalendar.set(Calendar.DAY_OF_MONTH, newVal);
        }


        if (mCalendar.get(Calendar.YEAR) == thisYear &&
                (mCalendar.get(Calendar.MONTH) + 1 > thisMonth || (mCalendar.get(Calendar.MONTH) + 1 == thisMonth) && mCalendar.get(Calendar.DATE)>thisDay)) {
            setDateCheck = true;
        }
        notifyDateChanged();
    }

    /**
     * The callback used to indicate the user changes\d the date.
     */
    public interface OnDateChangedListener {

        /**
         * Called upon a date change.
         *
         * @param view        The view associated with this listener.
         * @param year        The year that was set.
         * @param monthOfYear The month that was set (0-11) for compatibility
         *                    with {@link Calendar}.
         * @param dayOfMonth  The day of the month that was set.
         */
        void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth);
    }

    public DatePicker setOnDateChangedListener(OnDateChangedListener l) {
        mOnDateChangedListener = l;
        return this;
    }

    private void notifyDateChanged() {
        if (mOnDateChangedListener != null) {
            mOnDateChangedListener.onDateChanged(this, getYear(), getMonth(), getDayOfMonth());
        }
    }

    public int getYear() {
        return mCalendar.get(Calendar.YEAR);
    }

    public int getMonth() {
        return mCalendar.get(Calendar.MONTH) + 1;
    }

    public int getDayOfMonth() {
        return mCalendar.get(Calendar.DAY_OF_MONTH);
    }

//    public DatePicker setSoundEffect(Sound sound) {
//        mYearPicker.setSoundEffect(sound);
//        mMonthPicker.setSoundEffect(sound);
//        mDayOfMonthPicker.setSoundEffect(sound);
//        return this;
//    }

    @Override
    public void setSoundEffectsEnabled(boolean soundEffectsEnabled) {
        super.setSoundEffectsEnabled(soundEffectsEnabled);
        mYearPicker.setSoundEffectsEnabled(soundEffectsEnabled);
        mMonthPicker.setSoundEffectsEnabled(soundEffectsEnabled);
        mDayOfMonthPicker.setSoundEffectsEnabled(soundEffectsEnabled);
    }

    public DatePicker setRowNumber(int rowNumber) {
        mYearPicker.setRowNumber(rowNumber);
        mMonthPicker.setRowNumber(rowNumber);
        mDayOfMonthPicker.setRowNumber(rowNumber);
        return this;
    }

    public DatePicker setTextSize(float textSize) {
        mYearPicker.setTextSize(textSize);
        mMonthPicker.setTextSize(textSize);
        mDayOfMonthPicker.setTextSize(textSize);
        return this;
    }

    public DatePicker setFlagTextSize(float textSize) {
        mYearPicker.setFlagTextSize(textSize);
        mMonthPicker.setFlagTextSize(textSize);
        mDayOfMonthPicker.setFlagTextSize(textSize);
        return this;
    }

    public DatePicker setTextColor(int color) {
        mYearPicker.setTextColor(color);
        mMonthPicker.setTextColor(color);
        mDayOfMonthPicker.setTextColor(color);
        return this;
    }

    public DatePicker setFlagTextColor(int color) {
        mYearPicker.setFlagTextColor(color);
        mMonthPicker.setFlagTextColor(color);
        mDayOfMonthPicker.setFlagTextColor(color);
        return this;
    }

    public DatePicker setBackground(int color) {
        super.setBackgroundColor(color);
        mYearPicker.setBackground(color);
        mMonthPicker.setBackground(color);
        mDayOfMonthPicker.setBackground(color);
        return this;
    }

}
