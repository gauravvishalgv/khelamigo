import Box from "@mui/material/Box/Box";
import Grid from '@mui/material/Grid2';
import CreatePostCard from "./CreatePostCard";
import MenuItems from "./MenuItems";
import PostScroll from "./PostScroll";
import Contacts from "./Contacts";

import axios from 'axios';
import FormData from 'form-data';


  

export default function Main(){



    return (
        <Box sx={{background: '#f2f4f7', height: '90vh', overflow: 'hidden'}}>
            <Grid container spacing={10} sx={{ height: '100%' }}>
                <Grid
                    size={3}
                    sx={{
                        maxWidth: 360,
                        minWidth: 180,
                        height: '100%',
                        bgcolor: 'background.paper',
                        boxShadow: 4,
                    }}
                >
                    <MenuItems/>
                </Grid>
                <Grid
                    size={6}
                    sx={{
                        paddingLeft: '2%',
                        paddingRight: '2%',
                        paddingTop: '20px',
                        paddingBottom: '20px',
                        height: '100%', 
                        overflow: 'auto', // Enable scrolling
                        scrollbarWidth: 'none',
                        '&::-webkit-scrollbar': {
                            display: 'none', 
                        }
                    }}
                >
                    <>
                    <CreatePostCard/>
                    <PostScroll/>
                    </>
                    
                </Grid>
                <Grid
                    size={3}
                    sx={{
                        maxWidth: 360,
                        minWidth: 180,
                        height: '100%',
                        bgcolor: 'background.paper',
                        boxShadow: 4,
                    }}
                >
                    <Contacts/>
                </Grid>
            </Grid>
        </Box>
    )
}