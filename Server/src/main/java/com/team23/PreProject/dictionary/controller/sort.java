package com.team23.PreProject.dictionary.controller;

import com.team23.PreProject.answer.entity.answer;
import com.team23.PreProject.dictionary.repository.dic_repository;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Comparator;


public class sort implements Comparator<String>

{

    dic_repository drepo;

    public sort(dic_repository repo)
    {
        this.drepo = repo;
    }

    @Override
    public int compare(String a1, String a2)
        {
            if (drepo.findByName(a1).getScore() > drepo.findByName(a2).getScore())
                {
                    return -1; //타겟 = 큰것 , 방향 = +1 = 뒤로 보내기
                }

            else if (drepo.findByName(a1).getScore() < drepo.findByName(a2).getScore())

            {
                return +1;
            }
            return 0;
        }
}