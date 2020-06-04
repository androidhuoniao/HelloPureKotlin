package com.test.kotlin;

import java.util.List;

public class HelloDelegateJava {
    interface BasePresenter{
        List getData();
    }

    class ListPresenter implements BasePresenter {
        @Override
        public List getData() {
            return null;
        }
    }

    class HistoryListPreseenter implements BasePresenter {
        public BasePresenter mInnerPersenter;
        public HistoryListPreseenter(BasePresenter presenterImpl) {
           this.mInnerPersenter = presenterImpl;
        }
        @Override
        public List getData() {
            return mInnerPersenter.getData();
        }
    }
}
