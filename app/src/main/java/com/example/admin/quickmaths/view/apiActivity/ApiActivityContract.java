package com.example.admin.quickmaths.view.apiActivity;

import com.example.admin.quickmaths.model.display.DisplayObject;
import com.example.admin.quickmaths.utils.BasePresenter;
import com.example.admin.quickmaths.utils.BaseView;

import java.util.List;

/**
 * Created by Admin on 11/13/2017.
 */

public interface ApiActivityContract {
    interface View extends BaseView {
        //activity methods called by presenter
        void initRecyclerView(List<DisplayObject> itemList);
        void showProgress();

    }

    interface Presenter extends BasePresenter<View> {
        //presenter methods called by activity
        void makeCall(int pageCallUpdate, String upc);
        List<DisplayObject> mergeSort(List<DisplayObject> listItem);
        List<DisplayObject> merge(List<DisplayObject> left, List<DisplayObject> right);
    }
}
