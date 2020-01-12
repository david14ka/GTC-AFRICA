package com.dkz.gtcafrica.model.ui;

import android.content.Context;

import com.dkz.gtcafrica.R;
import com.dkz.gtcafrica.config.MyApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StudentBasedData {

    public static ArrayList<StudentMenu> studentMenus;

    public StudentBasedData() {
    }

    public static ArrayList<StudentMenu> getStudentMenus(Context application){

        studentMenus = new ArrayList<>();
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.help),Arrays.asList(application.getResources().getStringArray(R.array.button1)),true));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.community_based_rehabilitation),Arrays.asList(application.getResources().getStringArray(R.array.button2))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.transitional_facilities),Arrays.asList(application.getResources().getStringArray(R.array.button3))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.awareness_meeting),Arrays.asList(application.getResources().getStringArray(R.array.button4))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.outreaches),application.getResources().getString(R.string.upcoming_outreaches),Arrays.asList(application.getResources().getStringArray(R.array.button5))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.prevention),Arrays.asList(application.getResources().getStringArray(R.array.button6))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.intervention),Arrays.asList(application.getResources().getStringArray(R.array.button7))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.service_providers),Arrays.asList(application.getResources().getStringArray(R.array.button8))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.contact),Arrays.asList(application.getResources().getStringArray(R.array.button9))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.counseling_service),Arrays.asList(application.getResources().getStringArray(R.array.button10))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.resource_directory),Arrays.asList(application.getResources().getStringArray(R.array.button11))));
        studentMenus.add(new StudentMenu(application.getResources().getString(R.string.online_services),Arrays.asList(application.getResources().getStringArray(R.array.button12))));

        return studentMenus;
    }

    public static String[] menuList() {

        return new String[]{
                "HELP",
                "COMMUNITY BASED REHABILITATION",
                "TRANSITIONAL FACILITIES",
                "AWARENESS MEETING",
                "OUTREACHES",
                "PREVENTION",
                "INTERVENTION",
                "SERVICE PROVIDERS",
                "CONTACT",
                "COUNSELING SERVICE",
                "RESOURCE DIRECTORY",
                "ONLINE SERVICES"
        };
    }

}
