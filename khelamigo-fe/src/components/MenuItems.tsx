import * as React from 'react';
import List from '@mui/material/List';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';
import Collapse from '@mui/material/Collapse';
import FeedIcon from '@mui/icons-material/Feed';
import PeopleIcon from '@mui/icons-material/People';
import MessageIcon from '@mui/icons-material/Message';
import DynamicFeedIcon from '@mui/icons-material/DynamicFeed';
import ExpandLess from '@mui/icons-material/ExpandLess';
import ExpandMore from '@mui/icons-material/ExpandMore';
import StarBorder from '@mui/icons-material/StarBorder';
import { Avatar } from '@mui/material';

export default function MenuItems() {
  const [open, setOpen] = React.useState(true);

  const handleClick = () => {
    setOpen(!open);
  };

  return (
    <List
      sx={{ width: '100%', bgcolor: 'background.paper'}}
      component="nav"
      aria-labelledby="nested-list-subheader"
    >
      <ListItemButton>
        <ListItemIcon>
          <Avatar alt="Remy Sharp" src="/static/images/avatar/1.jpg" sx={{ width: 32, height: 32}}/>
        </ListItemIcon>
        <ListItemText primary="Gaurav Vishal" sx={{color: 'text.secondary'}} />
      </ListItemButton>
      <ListItemButton>
        <ListItemIcon>
          <PeopleIcon />
        </ListItemIcon>
        <ListItemText primary="Friends" sx={{color: 'text.secondary'}}/>
      </ListItemButton>
      <ListItemButton>
        <ListItemIcon>
          <MessageIcon />
        </ListItemIcon>
        <ListItemText primary="Inbox" sx={{color: 'text.secondary'}}/>
      </ListItemButton>
      <ListItemButton onClick={handleClick}>
        <ListItemIcon>
          <DynamicFeedIcon />
        </ListItemIcon>
        <ListItemText primary="Feeds" sx={{color: 'text.secondary'}}/>
        {open ? <ExpandLess /> : <ExpandMore />}
      </ListItemButton>
      <Collapse in={open} timeout="auto" unmountOnExit>
        <List component="div" disablePadding>
          <ListItemButton sx={{ pl: 4 }}>
            <ListItemIcon>
              <FeedIcon />
            </ListItemIcon>
            <ListItemText primary="All" sx={{color: 'text.secondary'}} />
          </ListItemButton>
          <ListItemButton sx={{ pl: 4 }}>
            <ListItemIcon>
              <PeopleIcon />
            </ListItemIcon>
            <ListItemText primary="Friends" sx={{color: 'text.secondary'}} />
          </ListItemButton>
          <ListItemButton sx={{ pl: 4 }}>
            <ListItemIcon>
              <StarBorder />
            </ListItemIcon>
            <ListItemText primary="Favorites" sx={{color: 'text.secondary'}} />
          </ListItemButton>
        </List>
      </Collapse>
    </List>
  );
}
