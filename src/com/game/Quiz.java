/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.game;

import com.impl.QuestionAnswerConsequenceImpl;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;

import com.model.Answer;
import com.model.Consequence;
import com.model.Question;
import com.model.PlayerType;
import com.model.QuestionAnswerConsequence;

/**
 *
 * @author lchastee
 */
public class Quiz {
    
    //private  ArrayList <Integer> questionsAnsweredCorrectly;
    private ArrayList <QuestionAnswerConsequence> qlist;
    private QuestionAnswerConsequenceImpl qi;
    
    private QuestionAnswerConsequence currentQAC;// Current Question: QuestionID
    private int rNum;
    
    public Quiz(PlayerType person)  throws SQLException, IllegalArgumentException{ 
        
        if(person != null){
            qi = new QuestionAnswerConsequenceImpl();
            //questionsAnsweredCorrectly = new  ArrayList<Integer>();
            currentQAC = null;
            // Get the list of questions for the player according to the player level.            
            qlist = qi.getQuestionsForLevel(person.getLevel());            
            Collections.shuffle(qlist);
            rNum = 0;
            // Add QuestionID to ArrayList for a list of questions to ask.
            
        }else{
            throw new IllegalArgumentException("Error in class Quizz, argument PlayerType is null!");
        }
    }
    
   
   /**
    *  
    * @return
    */
    public Question getNextRandomQuestion(){        
        
        
        if(qlist.isEmpty()){
            return null;
        }
        
        // Reset the counter.
        if(rNum >= qlist.size()){
            rNum = 0;
        }
        
        // set the current QuestionID
        if(qlist.size() > rNum){
            currentQAC = qlist.get(rNum);
        
        
        rNum++;
        
        return currentQAC.getQuestion();
        }
        return null;
    }
    
    /**
     * 
     * @return
     * @throws SQLException
     */
    public ArrayList <Answer> getMultipleChoiceAnswers() throws SQLException{
        ArrayList <Answer> al;
        
        if(currentQAC == null){ 
            return null;
        }
        al = qi.getAnswersForQuestion(currentQAC.getQuestion().getQuestionID());
        
        Collections.shuffle(al);
        return al;
    }
    
    /**
     * 
     * @param ans
     * @return
     */
    public boolean validateAnswer(Answer ans){        
        if(ans != null && currentQAC != null){
            if(ans.getAnswerID() == currentQAC.getAnswer().getAnswerID() ){
                if(!qlist.isEmpty()){                   
                    qlist.remove(currentQAC);
                    return true;
                }                
            }
        }
        return false;
    }
    /**
     * 
     * @return
     */
    public Consequence getConsequence (){
        if(currentQAC != null){
            return currentQAC.getConsequence();
        }
        return null;
    }
    
    /*
    public boolean validateAnswer(int choice){
        return false;
    }
    * */
    
    
}
