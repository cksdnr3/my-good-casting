import { createAsyncThunk, createSlice } from '@reduxjs/toolkit';
import { initial } from 'lodash-es';
import fileService from '../service/file.service';

export const fileRegister = createAsyncThunk(
    'FILE_REGISTER',
    async (formData) => {
        console.log('thunk enter');
        const response = await fileService.fileRegister(formData);

        return response.data;
    }
);

const initialState = {
    fileList: [
        {
            fileName: '',
            uuid: '',
        },
    ],
    reset: false,
};

const fileSlice = createSlice({
    name: 'file',
    initialState: initialState,
    reducers: {
        resetFile: (state = initialState) => {
            return {
                ...initialState,
                reset: !state.reset,
            };
        },
    },
    extraReducers: (builder) => {
        builder.addCase(fileRegister.fulfilled, (state, { payload }) => {
            console.log('file: ' + JSON.stringify(payload));
            return {
                ...state,
                fileList: payload,
            };
        });
    },
});

export const fileSelector = (state) => state.fileReducer;
export const { resetFile } = fileSlice.actions;
export default fileSlice.reducer;
