package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Individual;
import com.gatherProject.GatherBackend.Models.Ministry;

import java.util.concurrent.ExecutionException;

public interface MinistryService {

    public static final String COL_NAME="ministries";



    public Ministry persistMinistry(Ministry ministry) throws InterruptedException, ExecutionException;

    public Ministry getMinistry(String username) throws InterruptedException, ExecutionException;

    public void deleteMinistry(String username) throws InterruptedException, ExecutionException;
}
