package com.androidProject.footballChampionship.soccerdata.svg;



import android.content.Context;
import android.graphics.drawable.PictureDrawable;
import android.net.Uri;
import android.widget.ImageView;


import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.caverock.androidsvg.SVG;

import java.io.InputStream;

public class SvgLoader {
    private GenericRequestBuilder mRequestBuilder;

    public SvgLoader(Context context) {
        mRequestBuilder = Glide.with(context)
                .using(Glide.buildStreamModelLoader(Uri.class, context), InputStream.class)
                .from(Uri.class)
                .as(SVG.class)
                .transcode(new SvgDrawableTranscoder (), PictureDrawable.class)
                .sourceEncoder(new StreamEncoder())
                .cacheDecoder(new FileToStreamDecoder<SVG>(new SvgDecoder ()))
                .decoder(new SvgDecoder())
                .error(android.R.drawable.ic_dialog_alert)
                .animate(android.R.anim.fade_in)
                .listener(new com.androidProject.footballChampionship.soccerdata.svg.SvgSoftwareLayerSetter<Uri> ());
    }

    public void load(String url, ImageView imageView, int placeholder) {
        mRequestBuilder
                .load(Uri.parse(url))
                .placeholder(placeholder)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE).into(imageView);
    }
}
