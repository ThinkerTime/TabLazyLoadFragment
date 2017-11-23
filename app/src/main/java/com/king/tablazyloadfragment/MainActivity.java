package com.king.tablazyloadfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.king.tablazyloadfragment.base.BaseFragmentPagerAdapter;
import com.king.tablazyloadfragment.fragment.AgencyFragment;
import com.king.tablazyloadfragment.fragment.IndexFragment;
import com.king.tablazyloadfragment.fragment.MineFragment;
import com.king.tablazyloadfragment.fragment.NewsFragment;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.ll_bottom_tab)
    LinearLayout mLinearLayout;

    @BindView(R.id.vp_content)
    ViewPager mViewPager;

    @BindView(R.id.ll_tab_index)
    LinearLayout mIndexTab;
    @BindView(R.id.ll_tab_news)
    LinearLayout mNewTab;
    @BindView(R.id.ll_tab_agency)
    LinearLayout mAgencyTab;
    @BindView(R.id.ll_tab_mine)
    LinearLayout mMineTab;

    @BindView(R.id.img_tab_index)
    ImageView mIndex_img;
    @BindView(R.id.img_tab_news)
    ImageView mNews_img;
    @BindView(R.id.img_tab_agency)
    ImageView mAgency_img;
    @BindView(R.id.img_tab_mine)
    ImageView mMine_img;

    @BindView(R.id.text_tab_index)
    TextView mIndex_text;
    @BindView(R.id.text_tab_news)
    TextView mNews_text;
    @BindView(R.id.text_tab_agency)
    TextView mAgency_text;
    @BindView(R.id.text_tab_mine)
    TextView mMine_text;

    private ArrayList<Fragment> mFragmentList;
    private IndexFragment mIndexFragment;
    private NewsFragment mNewsFragment;
    private AgencyFragment mAgencyFragment;
    private MineFragment mMineFragment;

    private static final int TAB_INDEX = 0;
    private static final int TAB_NEWS = 1;
    private static final int TAB_AGENCY = 2;
    private static final int TAB_MINE = 3;
    private int mCurrentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFragmentList = new ArrayList<Fragment>();
        mIndexFragment = IndexFragment.newInstance();
        mNewsFragment = NewsFragment.newInstance();
        mAgencyFragment = AgencyFragment.newInstance();
        mMineFragment = MineFragment.newInstance();

        mFragmentList.add(mIndexFragment);
        mFragmentList.add(mNewsFragment);
        mFragmentList.add(mAgencyFragment);
        mFragmentList.add(mMineFragment);

        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new BaseFragmentPagerAdapter(fm, mFragmentList));
        mViewPager.setCurrentItem(TAB_INDEX);
        mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());

        setSelected(TAB_INDEX);

        mIndexTab.setOnClickListener(this);
        mNewTab.setOnClickListener(this);
        mAgencyTab.setOnClickListener(this);
        mMineTab.setOnClickListener(this);
    }

    public void setSelected(int tab) {
        mCurrentPosition = tab;
        mViewPager.setCurrentItem(mCurrentPosition);
        resetTab();
        switch (tab) {

            case TAB_INDEX:
                mIndex_img.setImageResource(R.mipmap.index_sel_icon_tab);
                mIndex_text.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case TAB_NEWS:
                mNews_img.setImageResource(R.mipmap.news_sel_icon_tab);
                mNews_text.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case TAB_AGENCY:
                mAgency_img.setImageResource(R.mipmap.im_sel_icon_tab);
                mAgency_text.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
            case TAB_MINE:
                mMine_img.setImageResource(R.mipmap.my_sel_icon_tab);
                mMine_text.setTextColor(getResources().getColor(R.color.colorAccent));
                break;
        }
    }

    private void resetTab() {
        mIndex_img.setImageResource(R.mipmap.index_icon_tab);
        mNews_img.setImageResource(R.mipmap.news_icon_tab);
        mAgency_img.setImageResource(R.mipmap.im_icon_tab);
        mMine_img.setImageResource(R.mipmap.my_icon_tab);

        mIndex_text.setTextColor(getResources().getColor(R.color.normal_text_gray));
        mNews_text.setTextColor(getResources().getColor(R.color.normal_text_gray));
        mAgency_text.setTextColor(getResources().getColor(R.color.normal_text_gray));
        mMine_text.setTextColor(getResources().getColor(R.color.normal_text_gray));
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.ll_tab_index:
                if (mCurrentPosition != TAB_INDEX) {
                    mCurrentPosition = TAB_INDEX;
                    setSelected(TAB_INDEX);
                }
                break;
            case R.id.ll_tab_news:
                if (mCurrentPosition != TAB_NEWS) {
                    mCurrentPosition = TAB_NEWS;
                    setSelected(TAB_NEWS);
                }
                break;
            case R.id.ll_tab_agency:
                if (mCurrentPosition != TAB_AGENCY) {
                    mCurrentPosition = TAB_AGENCY;
                    setSelected(TAB_AGENCY);
                }
                break;
            case R.id.ll_tab_mine:
                if (mCurrentPosition != TAB_MINE) {
                    mCurrentPosition = TAB_MINE;
                    setSelected(TAB_MINE);
                }
                break;

        }
    }
    public class MyOnPageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setSelected(position);
//            LogUtils.d("OnPageChangeListener");
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
