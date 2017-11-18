package devdeep.savinggrow;

/**
 * Created by KC_fr on 17/11/2560.
 */


import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class Tab2Expense extends Fragment {

    private EditText editDate, editCategory;
    private Button buttonCategory;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_expense, container, false);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        String date = " " + day + "/" + (month+1) + "/" + year;


        editDate = (EditText) rootView.findViewById(R.id.ed_date);
        editDate.setText(date);
        editDate.setOnClickListener(new View.OnClickListener() {
            public static final String TAG = "editDate onclick";

            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: FUCK");
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog;
                dialog = new DatePickerDialog(
                        getContext(), android.R.style.Theme_DeviceDefault_Light_Dialog,
                        dateSetListener, year, month, day );
                //dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month += 1;
                String date = " " + day + "/" + month + "/" + year;
                editDate.setText(date);
            }
        };


        // This is Button Choose Category related
        // Click and List Dialog will popup
        final String[] arrayIncomeCategory = {" Food"," Social Life"," Self-development"," Transportation"," Culture"," Household"," Apperel", " Beauty", " Health", " Education"," Gift", " Other"};

        editCategory = (EditText) rootView.findViewById(R.id.ed_category);

        buttonCategory = (Button) rootView.findViewById(R.id.btchooseCategory);
        buttonCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(rootView.getContext());
                builder.setTitle("Category");
                builder.setItems(arrayIncomeCategory, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String selected = arrayIncomeCategory[i];
                        editCategory.setText(selected);
                    }
                });
                builder.create();
                builder.show();
            }
        });

        return rootView;
    }
}
