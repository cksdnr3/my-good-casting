import React, { useState } from 'react';
import styled from 'styled-components';
import { Range, getTrackBackground } from 'react-range';
import DatePickerComponent from '../DatePicker/DatePicker';

const STEP = 1;
const MIN = 0;
const MAX = 100;

const CheckStyled = styled.span`
    cursor: pointer;
    display: flex;
    align-items: center;
    color: #2b3940 !important;
    font-size: 16px;
    color: inherit;
    &::before {
        content: '\f0c8';
        font-weight: 400;
        font-family: 'Font Awesome 5 Free';
        display: inline-block;
        color: #7e8989;
        margin-right: 11px;
        margin-top: 2px;
    }
    &.active {
        color: #2b3940 !important;
        font-weight: 600;
        &::before {
            content: '\f14a';
            font-weight: 900;
            color: #00b074;
        }
    }
`;

const Check = ({ children }) => {
    const [active, setActive] = useState(false);

    return (
        <CheckStyled
            className={`toggle-item ${active ? 'active' : ''}`}
            onClick={() => {
                setActive(!active);
            }}
        >
            {children}
        </CheckStyled>
    );
};

const Sidebar = () => {
    const [rangeValues, setRangeValues] = useState([0, 100]);
    return (
        <>
            {/* <!-- Sidebar Start --> */}
            <div className="widgets mb-11">
                <h4 className="font-size-6 font-weight-semibold mb-6">성별</h4>
                <ul className="list-unstyled filter-check-list">
                    <li className="mb-2">
                        <Check>남성</Check>
                    </li>
                    <li className="mb-2">
                        <Check>여성</Check>
                    </li>
                </ul>
            </div>
            <div className="widgets mb-11 ">
                <div>
                    <h4 className="font-size-6 font-weight-semibold mb-6 w-75">
                        촬영 기간
                    </h4>
                    {/* <!-- Range Slider --> */}
                    <h6 className="font-size-6 font-weight-semibold mb-6 w-75">
                        시작일
                    </h6>
                    <DatePickerComponent />
                    <h6 className="font-size-6 font-weight-semibold mb-6 w-75">
                        시작일
                    </h6>
                    <DatePickerComponent />
                </div>
            </div>
            <div className="widgets mb-11">
                <h4 className="font-size-6 font-weight-semibold mb-6">
                    Experience Level{' '}
                </h4>
                <ul className="list-unstyled filter-check-list">
                    <li className="mb-2">
                        <Check>All</Check>
                    </li>
                    <li className="mb-2">
                        <Check>Senior</Check>
                    </li>
                    <li className="mb-2">
                        <Check>Mid</Check>
                    </li>
                    <li className="mb-2">
                        <Check>Junior</Check>
                    </li>
                </ul>
            </div>
            <div className="widgets mb-11">
                <h4 className="font-size-6 font-weight-semibold mb-6">
                    Posted Time
                </h4>
                <ul className="list-unstyled filter-check-list">
                    <li className="mb-2">
                        <Check>Anytime</Check>
                    </li>
                    <li className="mb-2">
                        <Check>Last day</Check>
                    </li>
                    <li className="mb-2">
                        <Check>Last 3 days</Check>
                    </li>
                    <li className="mb-2">
                        <Check>Last week</Check>
                    </li>
                </ul>
            </div>
            {/* <!-- Sidebar End --> */}
        </>
    );
};

export default Sidebar;
