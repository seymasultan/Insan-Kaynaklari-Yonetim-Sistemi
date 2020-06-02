package com.seymasultan;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class Advert {

    private int hrId;
    private int  id;
    private String title;
    private String jobDescription;
    private String summary;
    private String personalInfo;
    private String professionalInfo;
    private String activationTimeString;
    private String disableTimeString;
    private Date activationTime;
    private Date disableTime;
    private ArrayList<String> basvuranUsersId;
    private ArrayList<String> kabulEdilenUsersId;

    public Advert() {
        basvuranUsersId = new ArrayList<>();
        kabulEdilenUsersId = new ArrayList<>();
    }

    public Advert(String title, String jobDescription, String summary, String personalInfo, String professionalInfo) {
        this.title = title;
        this.jobDescription = jobDescription;
        this.summary = summary;
        this.personalInfo = personalInfo;
        this.professionalInfo = professionalInfo;
        activationTime = Calendar.getInstance().getTime();
        basvuranUsersId = new ArrayList<>();
        kabulEdilenUsersId = new ArrayList<>();
    }

    public Advert(int id, String title, String jobDescription, String summary,
                  String personalInfo, String professionalInfo, String activationTimeString, String disableTimeString,
                  Date activationTime, Date disableTime, ArrayList<String> basvuranUsersId, ArrayList<String> kabulEdilenUsersId) {
        this.id = id;
        this.title = title;
        this.jobDescription = jobDescription;
        this.summary = summary;
        this.personalInfo = personalInfo;
        this.professionalInfo = professionalInfo;
        this.activationTimeString = activationTimeString;
        this.disableTimeString = disableTimeString;
        this.activationTime = activationTime;
        this.disableTime = disableTime;
        this.basvuranUsersId = basvuranUsersId;
        this.kabulEdilenUsersId = kabulEdilenUsersId;
        if(this.kabulEdilenUsersId ==null)
            this.kabulEdilenUsersId = new ArrayList<>();
    }

    public Advert(int advertId, int hrId, String title, String jobdescription, String summary,
                  String personalinfo, String professionalinfo, String activationtime, String disabletime) {

         this.id = advertId;
         this.hrId = hrId;
         this.title = title;
         this.jobDescription = jobdescription;
         this.summary = summary;
         this.personalInfo = personalinfo;
         this.professionalInfo = professionalinfo;
         this.activationTimeString = activationtime;
         this.disableTimeString = disabletime;

    }

    @Override
    public String toString() {
        return "Advert{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                ", summary='" + summary + '\'' +
                ", personalInfo='" + personalInfo + '\'' +
                ", professionalInfo='" + professionalInfo + '\'' +
                ", activationTimeString='" + activationTimeString + '\'' +
                ", disableTimeString='" + disableTimeString + '\'' +
                ", activationTime=" + activationTime +
                ", disableTime=" + disableTime +
                '}';
    }

    public void convertStringstoDates() {
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(activationTimeString);
            this.activationTime = date;
            date = new SimpleDateFormat("yyyy-MM-dd").parse(disableTimeString);
            this.disableTime = date;
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    public Advert(int id,String title, String summary) {
        this.id=id;
        this.title = title;
        this.summary=summary;
    }

    public int getHrId() {
        return hrId;
    }

    public void setHrId(int hrId) {
        this.hrId = hrId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPersonalInfo() {
        return personalInfo;
    }

    public void setPersonalInfo(String personalInfo) {
        this.personalInfo = personalInfo;
    }

    public String getProfessionalInfo() {
        return professionalInfo;
    }

    public void setProfessionalInfo(String professionalInfo) {
        this.professionalInfo = professionalInfo;
    }

    public Date getActivationTime() {
        return activationTime;
    }

    public Date getDisableTime() {
        return disableTime;
    }

    public String getActivationTimeString() {
        return activationTimeString;
    }

    public void setActivationTimeString(String activationTimeString) {
        this.activationTimeString = activationTimeString;
    }

    public String getDisableTimeString() {
        return disableTimeString;
    }

    public void setDisableTimeString(String disableTimeString) {
        this.disableTimeString = disableTimeString;
    }

    public ArrayList<String> getBasvuranUsersId() {
        return basvuranUsersId;
    }

    public void setBasvuranUsersId(ArrayList<String> basvuranUsersId) {
        this.basvuranUsersId = basvuranUsersId;
    }

    public boolean isUserApply(String id) {
        if(basvuranUsersId.contains(id) || kabulEdilenUsersId.contains(id))
            return  true;
        return false;
    }

    public ArrayList<String> getKabulEdilenUsersId() {
        return kabulEdilenUsersId;
    }

    public void setKabulEdilenUsersId(ArrayList<String> kabulEdilenUsersId) {
        this.kabulEdilenUsersId = kabulEdilenUsersId;
    }

    public void addConfirmedUser(String id) {
        if(basvuranUsersId.contains(id))           //Kabul edilen users'ın başvurusu var mı kontrol
            kabulEdilenUsersId.add(id);
    }
}
