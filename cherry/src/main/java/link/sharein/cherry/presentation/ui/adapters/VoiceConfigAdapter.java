package link.sharein.cherry.presentation.ui.adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.xutils.x;

import java.util.List;

import link.sharein.cherry.R;
import link.sharein.cherry.domain.model.VoiceConfig;
import link.sharein.cherry.network.converter.NetModelConverter;
import link.sharein.cherry.network.model.VoiceConfigGroup;
import link.sharein.cherry.presentation.presenters.GeneratePresenter;

/**
 * Created by jiang on 2016/3/6.
 */
public class VoiceConfigAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private GeneratePresenter.View mView;
    private VoiceConfigGroup voiceConfigGroup;


    public VoiceConfigAdapter(GeneratePresenter.View view, Context context) {
        this.mView = view;
        this.mContext = context;
        voiceConfigGroup = new VoiceConfigGroup();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.voice_config_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        VoiceConfig voiceConfig = NetModelConverter.convertToDomainModel(voiceConfigGroup.getContent().get(position));

        ((ViewHolder) holder).setUp(voiceConfig);
        if (voiceConfig.equals(mView.getConfiged())) {
            ((ViewHolder) holder).itemView.setBackgroundColor(holder.itemView.getResources().getColor(R.color.colorPrimary));
            ((ViewHolder) holder).name.setTextColor(holder.itemView.getResources().getColor(R.color.white));
        } else {
            ((ViewHolder) holder).itemView.setBackgroundColor(Color.argb(0, 0, 0, 0));
            ((ViewHolder) holder).name.setTextColor(holder.itemView.getResources().getColor(R.color.blackGray));
        }
    }

    @Override
    public int getItemCount() {
        return voiceConfigGroup.getContent().size();
    }

    public void addConfigs(VoiceConfigGroup voiceConfigGroup) {
        this.voiceConfigGroup = voiceConfigGroup;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView img;
        private TextView name;


        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
            name = (TextView) itemView.findViewById(R.id.name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            VoiceConfig voiceConfig = NetModelConverter.convertToDomainModel(voiceConfigGroup.getContent().get(getAdapterPosition()));
            v.setBackgroundColor(v.getResources().getColor(R.color.colorPrimary));
            mView.onConfigClick(voiceConfig);
        }

        public void setUp(VoiceConfig voiceConfig) {
            x.image().bind(img, voiceConfig.getIcon());
            name.setText(voiceConfig.getName());
        }
    }

    public VoiceConfigGroup getVoiceConfigGroup() {
        return voiceConfigGroup;
    }

    public void setVoiceConfigGroup(VoiceConfigGroup voiceConfigGroup) {
        this.voiceConfigGroup = voiceConfigGroup;
    }
}
