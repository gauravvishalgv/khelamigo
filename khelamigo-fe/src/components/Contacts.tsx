import * as React from 'react';
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import { Avatar, Stack, Typography } from '@mui/material';

export default function Contacts() {

  return (
    <Stack spacing={0}>
        <Typography gutterBottom component="div" sx={{ fontWeight: 'bold', color: 'text.secondary', fontSize:16, paddingLeft: '20px', paddingTop: '10px' }}>Contacts</Typography>
        <List
            sx={{ width: '100%', bgcolor: 'background.paper'}}
            component="nav"
            aria-labelledby="nested-list-subheader"
        >
            {Array.from({ length: 20 }).map((_, index) => (
            <ListItemButton>
                <ListItemIcon>
                    <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" sx={{ width: 32, height: 32}}/>
                </ListItemIcon>
                <ListItemText primary="Gaurav Vishal" sx={{color: 'text.secondary', mx: -1.5}} />
            </ListItemButton>
            ))}
        
        </List>
    </Stack>
    
  );
}
