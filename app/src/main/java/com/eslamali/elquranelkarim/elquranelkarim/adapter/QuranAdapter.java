package com.eslamali.elquranelkarim.elquranelkarim.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.eslamali.elquranelkarim.R;
import com.eslamali.elquranelkarim.elquranelkarim.data.model.surah;
import com.eslamali.elquranelkarim.elquranelkarim.ui.activity.MainActivity;
import com.eslamali.elquranelkarim.elquranelkarim.ui.fragment.homeCycle.QuranFragment;
import com.eslamali.elquranelkarim.elquranelkarim.ui.fragment.homeCycle.quranCycle.QuranDetailsFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.eslamali.elquranelkarim.elquranelkarim.helper.HelperMethod.customToast;
import static com.eslamali.elquranelkarim.elquranelkarim.helper.HelperMethod.replaceFragment;
import static com.eslamali.elquranelkarim.elquranelkarim.helper.InternetState.isActive;

public class QuranAdapter extends RecyclerView.Adapter<QuranAdapter.ViewHolder> {

    private Context context;
    private Activity activity;
    private List<surah> surahList = new ArrayList<>();
    private QuranFragment quranFragment;

    public QuranAdapter(Context context, List<surah> surahList, QuranFragment quranFragment) {
        this.context = context;
        this.surahList = surahList;
        this.quranFragment = quranFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_quran,
                parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        setData(holder, position);
        setAction(holder, position);
    }

    private void setData(ViewHolder holder, int position) {
        holder.itemQuranTxtSurah.setText(surahList.get(position).getIndex() + "." + "سورة " + surahList.get(position).getName());
    }

    private void setAction(ViewHolder holder, int position) {
        holder.itemQuranReadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity mainActivity = (MainActivity) context;
                QuranDetailsFragment detailsFragment = new QuranDetailsFragment();
                detailsFragment.index = surahList.get(position).getIndex();
                replaceFragment(mainActivity.getSupportFragmentManager(), R.id.main_activity_frame_layout_id, detailsFragment);
            }
        });

        holder.itemQuranSoundBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isActive(context)) {

                    quranFragment.setMediaPlayer(surahList.get(position).getIndex(), "سورة " + surahList.get(position).getName());
                } else {
                    customToast((MainActivity) context, context.getString(R.string.noInternet), true);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
        return surahList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private View view;
        @BindView(R.id.item_quran_read_btn)
        Button itemQuranReadBtn;
        @BindView(R.id.item_quran_txt_surah)
        TextView itemQuranTxtSurah;
        @BindView(R.id.item_quran_sound_btn)
        Button itemQuranSoundBtn;

        public ViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            ButterKnife.bind(this, view);
        }
    }
}
