package com.crud.tasks.trello.facade;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloList;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.mapper.TrelloMapper;
import com.crud.tasks.service.TrelloService;
import com.crud.tasks.trello.validator.TrelloValidator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;

@RunWith(MockitoJUnitRunner.class)
public class TrelloMapperTestSuite {
    @InjectMocks
    private TrelloFacade trelloFacade;

    @Mock
    private TrelloService trelloService;

    @Mock
    private TrelloValidator trelloValidator;

    @Mock
    private TrelloMapper trelloMapper;

    @Test
    public void testShouldFetchEmpty() {
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("1", "test", false));

        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("1", "test", trelloListDtos));

        List<TrelloList> mappedTrelloList = new ArrayList<>();
        mappedTrelloList.add(new TrelloList("1", "test", false));

        List<TrelloBoard> mappedTrelloBoards = new ArrayList<>();
        mappedTrelloBoards.add(new TrelloBoard("1", "test", mappedTrelloList));

        Mockito.when(trelloService.fetchTrelloBoards()).thenReturn(trelloBoardDtos);
        Mockito.when(trelloMapper.mapToBoards(trelloBoardDtos)).thenReturn(mappedTrelloBoards);
        Mockito.when(trelloMapper.mapToBoardDto(anyList())).thenReturn(new ArrayList<>());
        Mockito.when(trelloValidator.validateTrelloBoards(mappedTrelloBoards)).thenReturn(new ArrayList<>());

        //When
        List<TrelloBoardDto> trelloBoardDtos1 = trelloFacade.fetchTrelloBoards();

        //Then
        Assert.assertNotNull(trelloBoardDtos1);
        Assert.assertEquals(0, trelloBoardDtos1.size());
    }
}
