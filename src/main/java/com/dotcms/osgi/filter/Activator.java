package com.dotcms.osgi.filter;



import org.osgi.framework.BundleContext;
import com.dotmarketing.osgi.GenericBundleActivator;

public class Activator extends GenericBundleActivator {


    final static String FILTER_NAME = "normalizerFilter";



    public void start(BundleContext bundleContext) throws Exception {


        System.out.println("## [" + this.getClass() + "] installing filter " + UriNormalizerFilter.class.getCanonicalName());
        new TomcatServletFilterUtil().addFilter(FILTER_NAME, new UriNormalizerFilter(), FilterOrder.FIRST, "*", "/");


    }



    public void stop(BundleContext context) {
        System.out.println("## [" + this.getClass() + "] removing filter " + UriNormalizerFilter.class.getCanonicalName());
        new TomcatServletFilterUtil().removeFilter(FILTER_NAME);

    }


}


