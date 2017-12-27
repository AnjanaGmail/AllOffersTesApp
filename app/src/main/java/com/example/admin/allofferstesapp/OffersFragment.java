package com.example.admin.allofferstesapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


/*
created by Anjana
 */

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link OffersFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link OffersFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OffersFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private List<NewOffers> offersList = new ArrayList<>();
    private ArrayList<OfferView> mViewList;
    private RelativeLayout relativeLayout;
    private View childView;
    private int mContainerWidth;
    private GestureDetector mGesture;
    private DisplayMetrics displayMetrics;

    int currentlyFocusedItem = 0;
    private static final int PAGES = 10;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Typeface fontIcons;

    private OnFragmentInteractionListener mListener;

    public static OffersFragment newInstance(Typeface fontIcons) {
        OffersFragment offersFragment = new OffersFragment();
        offersFragment.fontIcons = fontIcons;
        return offersFragment;
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OffersFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static OffersFragment newInstance(String param1, String param2) {
        OffersFragment fragment = new OffersFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        relativeLayout = (RelativeLayout) getView().findViewById(R.id.rlToDoList);
        populateList();
        if (offersList != null && !offersList.isEmpty()) {
            //setting offers once the offerslist filled
            setOffers(offersList);
        }
    }

    // setting offers
    private void setOffers(List<NewOffers> newOffersList) {
        int offset = newOffersList.size();
        for (int i = 0; i < newOffersList.size(); i++) {
            //creating custom view
            OfferView offerView = new OfferView(getContext(), newOffersList.get(i), fontIcons, mContainerWidth);
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, mContainerWidth);
            offerView.setId(i + offset);
            if (i == 0) {
                params.addRule(RelativeLayout.ALIGN_PARENT_TOP, RelativeLayout.TRUE);
            } else {
                //params for list view
                params.topMargin = -mContainerWidth / 2 * i;
                params.addRule(RelativeLayout.BELOW, i - 1);
            }
            // adding view to list
            mViewList.add(offerView);
            offerView.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    childView = view;
                    return mGesture.onTouchEvent(motionEvent);
                }
            });
            //adding view to container
            relativeLayout.addView(offerView, params);
        }
        // displaying all offers
        displayOffers();
        //bringing element to front
        for (int j = mViewList.size() - 1; j >= 0; j--) {
            mViewList.get(j).bringToFront();
        }
    }

    void populateList() {

        //As there is no api exist, so Creating hardcoded local data for offers
        Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.mipmap.image);
        Bitmap bitmap2 = BitmapFactory.decodeResource(getResources(), R.mipmap.pasta);
        Bitmap bitmap3 = BitmapFactory.decodeResource(getResources(), R.mipmap.sunglss);
        Bitmap bitmap4 = BitmapFactory.decodeResource(getResources(), R.mipmap.shop);
        Bitmap bitmap5 = BitmapFactory.decodeResource(getResources(), R.mipmap.juice);

        Bitmap coffee_day_brand_icon = BitmapFactory.decodeResource(getResources(), R.mipmap.cofee_day);
        Bitmap offer_icon = BitmapFactory.decodeResource(getResources(), R.mipmap.offers);

        NewOffers newOffer = new NewOffers();
        newOffer.setImage(bitmap1);
        newOffer.setDescription(getResources().getString(R.string.offer1_desc));
        newOffer.setBrandName(getResources().getString(R.string.offer1_band_name));
        newOffer.setBrandIcon(coffee_day_brand_icon);
        offersList.add(newOffer);

        NewOffers newOffer1 = new NewOffers();
        newOffer1.setImage(bitmap2);
        newOffer1.setDescription(getResources().getString(R.string.offer2_desc));
        newOffer1.setBrandName(getResources().getString(R.string.offer2_band_name));
        newOffer1.setBrandIcon(offer_icon);
        offersList.add(newOffer1);

        NewOffers newOffer2 = new NewOffers();
        newOffer2.setImage(bitmap3);
        newOffer2.setBrandName(getResources().getString(R.string.offer3_band_name));
        newOffer2.setDescription(getResources().getString(R.string.offer3_desc));
        newOffer2.setBrandIcon(offer_icon);
        offersList.add(newOffer2);

        NewOffers newOffer3 = new NewOffers();
        newOffer3.setImage(bitmap4);
        newOffer3.setBrandName(getResources().getString(R.string.offer4_band_name));
        newOffer3.setDescription(getResources().getString(R.string.offer4_desc));
        newOffer3.setBrandIcon(offer_icon);
        offersList.add(newOffer3);

        NewOffers newOffer4 = new NewOffers();
        newOffer4.setImage(bitmap5);
        newOffer4.setBrandName(getResources().getString(R.string.offer5_band_name));
        newOffer4.setDescription(getResources().getString(R.string.offer5_desc));
        newOffer4.setBrandIcon(offer_icon);
        offersList.add(newOffer4);

        NewOffers newOffer5 = new NewOffers();
        newOffer5.setImage(bitmap1);
        newOffer5.setDescription(getResources().getString(R.string.offer1_desc));
        newOffer5.setBrandName(getResources().getString(R.string.offer1_band_name));
        newOffer5.setBrandIcon(coffee_day_brand_icon);
        offersList.add(newOffer5);

        NewOffers newOffer6 = new NewOffers();
        newOffer6.setImage(bitmap2);
        newOffer6.setDescription(getResources().getString(R.string.offer2_desc));
        newOffer6.setBrandName(getResources().getString(R.string.offer2_band_name));
        newOffer6.setBrandIcon(offer_icon);
        offersList.add(newOffer6);

        NewOffers newOffer7 = new NewOffers();
        newOffer7.setImage(bitmap3);
        newOffer7.setBrandName(getResources().getString(R.string.offer3_band_name));
        newOffer7.setDescription(getResources().getString(R.string.offer3_desc));
        newOffer7.setBrandIcon(offer_icon);
        offersList.add(newOffer7);

        NewOffers newOffer8 = new NewOffers();
        newOffer8.setImage(bitmap4);
        newOffer8.setBrandName(getResources().getString(R.string.offer4_band_name));
        newOffer8.setDescription(getResources().getString(R.string.offer4_desc));
        newOffer8.setBrandIcon(offer_icon);
        offersList.add(newOffer8);

        NewOffers newOffer9 = new NewOffers();
        newOffer9.setImage(bitmap5);
        newOffer9.setBrandName(getResources().getString(R.string.offer5_band_name));
        newOffer9.setDescription(getResources().getString(R.string.offer5_desc));
        newOffer9.setBrandIcon(offer_icon);
        offersList.add(newOffer9);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //initialized the metrics
        displayMetrics = new DisplayMetrics();
        getActivity().getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        mContainerWidth = (int) (displayMetrics.widthPixels * 0.75);
        //creating Gesture to container
        mGesture = new GestureDetector(getActivity(), mOnGesture);

        mViewList = new ArrayList<>();
        return inflater.inflate(R.layout.fragment_every_where, container, false);
    }

    //Populating all offers one by one in container
    private void displayOffers() {

        int firstCard = mContainerWidth;
        int otherCard = firstCard;
        int overlap = (int) (firstCard * 0.65);

        // int overlap = (int) (firstCard * 0.85);
        int difference = firstCard - otherCard - overlap;

        if (mViewList != null) {
            for (int i = 0; i < mViewList.size(); i++) {
                final OfferView offerView = mViewList.get(i);

                final RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, otherCard);

                params.topMargin = (i - currentlyFocusedItem) * otherCard;
                if (i == currentlyFocusedItem) {
                    params.height = firstCard;
                } else if (i > currentlyFocusedItem) {
                    params.topMargin = params.topMargin + (difference * (i - currentlyFocusedItem));
                }
                offerView.setLayoutParams(params);

            }

            if (mViewList.size() >= (currentlyFocusedItem + 1)) {
                mViewList.get(currentlyFocusedItem).bringToFront();

                if (currentlyFocusedItem > 0) {
                    //starting animation of the view which is moved up
                    //startAnimation(mViewList.get(currentlyFocusedItem-1));
                }
            }

        }
    }

    //Appying animation to view
    private void startAnimation(OfferView offerView) {
        //int centerX = (relativeLayout.getLeft() + relativeLayout.getRight()) / 2;
        //int centerY = (relativeLayout.getTop() + relativeLayout.getBottom()) / 2;
        /*ObjectAnimator anim = ObjectAnimator.ofFloat(offerView, "y", mContainerWidth/2 - mContainerWidth/2);
        *//*int centerX = (relativeLayout.getTop() + relativeLayout.getBottom()) / 2;
        int centerY = relativeLayout.getTop();

        int endRadius = Math.max(relativeLayout.getWidth(), relativeLayout.getHeight());
        Animator anim = ViewAnimationUtils.createCircularReveal(relativeLayout, centerX, centerY, 0, endRadius);*//*
        anim.setDuration(1000);
        anim.start();*/

        Animation slide = null;
        slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -5.0f);

        slide.setDuration(400);
        slide.setFillAfter(true);
        slide.setFillEnabled(true);
        offerView.startAnimation(slide);
    }

    private void moveDown() {
        if (currentlyFocusedItem > 0) {
            currentlyFocusedItem = currentlyFocusedItem - 1;
        }
        displayOffers();
    }

    private void moveUp() {
        if (currentlyFocusedItem < offersList.size() - 1) {
            currentlyFocusedItem += 1;
        }
        displayOffers();
    }


    private GestureDetector.OnGestureListener mOnGesture = new GestureDetector.SimpleOnGestureListener() {


        private static final int SWIPE_MIN_DISTANCE = 60;
        private static final int SWIPE_THRESHOLD_VELOCITY = 500;

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if (e2.getY() - e1.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                moveDown();
            }
            if (e1.getY() - e2.getY() > SWIPE_MIN_DISTANCE && Math.abs(velocityY) > SWIPE_THRESHOLD_VELOCITY) {
                moveUp();
            }
            return false;
        }
    };

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
