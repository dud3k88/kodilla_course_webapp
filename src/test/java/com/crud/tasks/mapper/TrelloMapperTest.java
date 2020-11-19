package com.crud.tasks.mapper;


import com.crud.tasks.domain.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTest {
    @Autowired
    TrelloMapper trelloMapper;

    @Test
    public void testMapToList() {
        //given
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(new TrelloListDto("list1", "jeden", true));

        //when
        List<TrelloList> trelloLists = trelloMapper.mapToList(trelloListsDto);

        //then
        Assert.assertEquals(1, trelloLists.size());
        Assert.assertTrue(trelloLists.contains(new TrelloList("list1", "jeden", true)));
    }

    @Test
    public void testMapToListDto() {
        //given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("list2", "dwa", true));

        //when
        List<TrelloListDto> trelloListsDto = trelloMapper.mapToListDto(trelloLists);

        //then
        Assert.assertEquals(1, trelloListsDto.size());

    }


    @Test
    public void testMapToBoard() {
        //given
        TrelloListDto  trelloListDto = new TrelloListDto("1", "firstDto", true);
        List<TrelloListDto> trelloListsDto = new ArrayList<>();
        trelloListsDto.add(trelloListDto);

        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("1", "firstDto", trelloListsDto);
        List<TrelloBoardDto> trelloBoardsDto = new ArrayList<>();
        trelloBoardsDto.add(trelloBoardDto);

        //when
        List<TrelloBoard> trelloBoards = trelloMapper.mapToBoards(trelloBoardsDto);

        //then
        Assert.assertEquals(1, trelloBoards.size());
    }

    @Test
    public void testMapToBoardDto() {
        //given
        TrelloList trelloList = new TrelloList("1", "first", true);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList);

        TrelloBoard trelloBoard = new TrelloBoard("1", "first", trelloLists);
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard);

        //then
        List<TrelloBoardDto> trelloBoardDto = trelloMapper.mapToBoardDto(trelloBoards);

        //then
        Assert.assertEquals(1, trelloBoardDto.size());
    }

    @Test
    public void mapToCard() {
        //given
        TrelloCardDto trelloCardDto = new TrelloCardDto("card1", "des1", "pos1", "id1");

        //when
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //then
        Assert.assertEquals(trelloCardDto.getDescription(), trelloCard.getDescription());
    }

    @Test
    public void mapToCardDto() {
        //given
        TrelloCard trelloCard = new TrelloCard("card1", "des1", "pos1", "id1");

        //when
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //then
        Assert.assertEquals(trelloCard.getName(), trelloCardDto.getName());
        Assert.assertEquals(trelloCard.getDescription(), trelloCardDto.getDescription());
        Assert.assertEquals(trelloCard.getPos(), trelloCardDto.getPos());
    }

}