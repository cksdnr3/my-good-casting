import { useDispatch } from 'react-redux';
import hireService from '../service/hire.service';

const { createSlice, createAsyncThunk } = require('@reduxjs/toolkit');

export const hireList = createAsyncThunk('HIRE_LIST', async (pageRequest) => {
    console.log('createAsyncThunk enter: ' + JSON.stringify(pageRequest));
    if (pageRequest.page === 0) {
        return null;
    }

    const response = await hireService.hireList(pageRequest);
    return response.data;
});

const hireSlice = createSlice({
    name: 'hire',
    initialState: {
        pageRequest: {
            page: 1,
            size: 10,
            type: '',
            sort: 'hireId',
            ffrom: 0,
            fto: 0,
            conKeyword: '',
            castKeyword: '',
            gfrom: 0,
            gto: 0,
            tkeyword: 0,
            pkeyword: 0,
        },
        pageResult: {
            pageList: [],
            dtoList: [],
            page: 1,
            size: 10,
            totalPage: 0,
            start: 0,
            end: 0,
            prev: false,
            next: false,
            totalElement: 0,
        },
    },
    reducers: {
        pageListChange: (state, { payload }) => {
            return (state.page = payload);
        },
    },
    extraReducers: (builder) => {
        builder.addCase(hireList.fulfilled, (state, { payload }) => {
            console.log('payload: ' + JSON.stringify(payload));

            if (!payload) {
                state.page = 1;
                return state;
            }

            return {
                ...state,
                pageResult: { ...payload },
            };
        });
    },
});

export const hireSelector = (state) => state.hireReducer;

export const { pageListChange, search, pageChange } = hireSlice.actions;
export default hireSlice.reducer;
