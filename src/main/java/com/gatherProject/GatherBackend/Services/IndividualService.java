package com.gatherProject.GatherBackend.Services;

import com.gatherProject.GatherBackend.Models.Individual;
import java.util.concurrent.ExecutionException;

public interface IndividualService {

    public static final String COL_NAME="individuals";



    public Individual persistIndividual(Individual individual) throws InterruptedException, ExecutionException;

    public Individual getIndividual(String username) throws InterruptedException, ExecutionException;

    public void deleteIndividual(String username) throws InterruptedException, ExecutionException;



}
