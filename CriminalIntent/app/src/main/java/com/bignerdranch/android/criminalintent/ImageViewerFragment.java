package com.bignerdranch.android.criminalintent;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

/**
 * Created by ben on 10/29/15.
 */
public class ImageViewerFragment extends DialogFragment {

    private static final String PIC_PATH = "path";

    private ImageView mImageView;

    public static ImageViewerFragment newInstance(File file) {
        Bundle args = new Bundle();
        args.putString(PIC_PATH, file.getPath());

        ImageViewerFragment fragment = new ImageViewerFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        String path = getArguments().getString(PIC_PATH);

        View v = LayoutInflater.from(getActivity())
                .inflate(R.layout.dialog_image, null);

        Bitmap bitmap = PictureUtils.getScaledBitmap(path, getActivity());
        mImageView = (ImageView) v.findViewById(R.id.crime_photo_dialog);
        mImageView.setImageBitmap(bitmap);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Crime Image")
                .setPositiveButton(android.R.string.ok, null)
                .create();
    }
}
